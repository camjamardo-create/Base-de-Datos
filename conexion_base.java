import java.sql.Connection; // Importa la clase Connection para manejar conexiones a bases de datos
import java.sql.DriverManager; // Importa la clase DriverManager para gestionar los controladores de bases de datos
import java.sql.SQLException; // Importa la clase SQLException para manejar errores de SQL

public class conexion_base {
    public static Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gestion_turnos";
        String usuario = "root";
        String contraseña = "";
        return DriverManager.getConnection(url, usuario, contraseña);
    }
    public static void main(String[] args) {
        try (Connection conexion = conexion()) {
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}

