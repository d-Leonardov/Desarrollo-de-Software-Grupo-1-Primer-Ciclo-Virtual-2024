import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/universidad"; // Cambiar el
    private static final String USUARIO = "root"; // Cambiar el usuario
    private static final String PASSWORD = "Leonardo3839332"; // Cambiar la contraseña del usuario

    public static Connection conectarBD() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
