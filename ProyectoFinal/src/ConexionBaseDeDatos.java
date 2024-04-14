import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Leonardo3839332";

    public static Connection conectarBD() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
