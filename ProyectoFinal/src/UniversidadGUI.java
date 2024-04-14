import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversidadGUI extends JFrame {
    private JComboBox<String> tablaSelector;
    private JTable tablaContenido;
    private DefaultTableModel tableModel;

    private JButton btnActualizar;
    private JButton btnAdicionarFila;
    private JButton btnInsertar;
    private JButton btnEliminarRegistro;

    private Connection connection;

    public UniversidadGUI() {
        setTitle("Visualizar Contenido de Tablas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel selectorPanel = new JPanel(new FlowLayout());
        JLabel lblTabla = new JLabel("Seleccionar Tabla:");
        tablaSelector = new JComboBox<>(new String[]{"", "Persona", "Universidad", "Facultad", "Profesor", "Carrera", "Estudiante", "Curso"});
        selectorPanel.add(lblTabla);
        selectorPanel.add(tablaSelector);

        panel.add(selectorPanel, BorderLayout.NORTH);

        JPanel contenidoPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        tablaContenido = new JTable();
        tablaContenido.setBackground(Color.WHITE); 
        scrollPane.setViewportView(tablaContenido);
        contenidoPanel.add(scrollPane, BorderLayout.CENTER);
        contenidoPanel.setBackground(Color.WHITE);
        panel.add(contenidoPanel, BorderLayout.CENTER);

        btnActualizar = new JButton("Actualizar Registro");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRegistro((String) tablaSelector.getSelectedItem());
            }
        });

        btnAdicionarFila = new JButton("Adicionar Fila");
        btnAdicionarFila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarFila();
            }
        });

        btnInsertar = new JButton("Insertar Registro");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarRegistro();
            }
        });

        btnEliminarRegistro = new JButton("Eliminar Registro");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro((String) tablaSelector.getSelectedItem());
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnActualizar);
        btnPanel.add(btnAdicionarFila);
        btnPanel.add(btnInsertar);
        btnPanel.add(btnEliminarRegistro);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        try {
            connection = ConexionBaseDeDatos.conectarBD();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

        tablaSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarContenidoTabla((String) tablaSelector.getSelectedItem());
            }
        });
    }

    private void cargarContenidoTabla(String nombreTabla) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + nombreTabla);
            ResultSet resultSet = statement.executeQuery();

            tableModel = new DefaultTableModel();
            tablaContenido.setModel(tableModel);

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                tableModel.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] fila = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                tableModel.addRow(fila);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar contenido de la tabla");
        }
    }

    private void actualizarRegistro(String nombreTabla) {
        try {
            int filas = tableModel.getRowCount();
            int columnas = tableModel.getColumnCount();

            if (filas == 0) {
                JOptionPane.showMessageDialog(null, "No es posible actualizar una tabla vacía.");
                return;
            }

            for (int i = 0; i < filas; i++) {
                boolean filaCompleta = true;

                for (int j = 0; j < columnas; j++) {
                    Object valorCelda = tableModel.getValueAt(i, j);
                    if (valorCelda == null || valorCelda.toString().isEmpty()) {
                        filaCompleta = false;
                        break;
                    }
                }

                if (!filaCompleta) {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los campos de la fila " + (i + 1));
                    return;
                }

                StringBuilder queryBuilder = new StringBuilder("UPDATE ").append(nombreTabla).append(" SET ");
                for (int j = 0; j < columnas; j++) {
                    String nombreColumna = tableModel.getColumnName(j);
                    Object valorCelda = tableModel.getValueAt(i, j);
                    String valor;
                    if (valorCelda instanceof java.sql.Date) {
                        valor = ((java.sql.Date) valorCelda).toString();
                    } else {
                        valor = String.valueOf(valorCelda);
                    }
                    queryBuilder.append(nombreColumna).append(" = '").append(valor).append("'");
                    if (j < columnas - 1) {
                        queryBuilder.append(", ");
                    }
                }
                queryBuilder.append(" WHERE ");
                String nombreColumnaID = tableModel.getColumnName(0);
                Object valorColumnaID = tableModel.getValueAt(i, 0);
                String valor;
                if (valorColumnaID instanceof java.sql.Date) {
                    valor = ((java.sql.Date) valorColumnaID).toString();
                } else {
                    valor = String.valueOf(valorColumnaID);
                }
                queryBuilder.append(nombreColumnaID).append(" = '").append(valor).append("'");

                PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
                statement.executeUpdate();
                statement.close();
            }

            JOptionPane.showMessageDialog(null, "campo actualizado correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el campo");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ninguna tabla ha sido seleccionada");
        }
    } 

    private void adicionarFila() {
        try {
            tableModel.addRow(new Object[tableModel.getColumnCount()]);
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ninguna tabla ha sido seleccionada");
        }
    }

    private void insertarRegistro() {
        try {
            tableModel.getRowCount();
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ninguna tabla ha sido seleccionada");
        }
        int filas = tableModel.getRowCount();

       if (filas > 0 && verificarFilaVacia(filas - 1)) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna información para insertar en la base de datos");
            return;
        }

        Object[] datosFila = new Object[tableModel.getColumnCount()];
        for (int i = 0; i < datosFila.length; i++) {
            datosFila[i] = tableModel.getValueAt(filas - 1, i);
        }

        try {
            StringBuilder queryBuilder = new StringBuilder("INSERT INTO ").append(tablaSelector.getSelectedItem()).append(" VALUES (");
            for (int i = 0; i < datosFila.length; i++) {
                if (datosFila[i] instanceof String) {
                    queryBuilder.append("'").append(datosFila[i]).append("'");
                } else {
                    queryBuilder.append(datosFila[i]);
                }
                if (i < datosFila.length - 1) {
                    queryBuilder.append(", ");
                }
            }
            queryBuilder.append(")");

            PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
            statement.executeUpdate();
            statement.close();

            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");

            cargarContenidoTabla((String) tablaSelector.getSelectedItem());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar el registro");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private boolean verificarFilaVacia(int fila) {
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            if (tableModel.getValueAt(fila, i) != null && !tableModel.getValueAt(fila, i).toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void eliminarRegistro(String nombreTabla) {
        int filaSeleccionada = tablaContenido.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un registro para eliminar.");
            return;
        }

        Object valorColumnaID = tableModel.getValueAt(filaSeleccionada, 0);
        String nombreColumnaID = tableModel.getColumnName(0);

        try {
            String query = "DELETE FROM " + nombreTabla + " WHERE " + nombreColumnaID + " = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, valorColumnaID);

            statement.executeUpdate();
            statement.close();

            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

            cargarContenidoTabla(nombreTabla);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro"); 
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UniversidadGUI();
            }
        });
    }
}
