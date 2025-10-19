import java.sql.Connection; // Importa la clase Connection para manejar conexiones a bases de datos
import java.sql.DriverManager; // Importa la clase DriverManager para gestionar los controladores de bases de datos
import java.sql.SQLException; // Importa la clase SQLException para manejar errores de SQL

public class conexion_base {
    public static void main(String[] args){
        //Datos de conexión
        String url = "jdbc:mysql://localhost:3306/gestion_turnos";
        String usuario = "root";
        String contraseña = "";

        try (
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña)
            ) {
            System.out.println("Conexión exitosa a la base de datos");

            // Cerrar la conexión
            conexion.close();
            System.out.println("Conexión cerrada");
            
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
