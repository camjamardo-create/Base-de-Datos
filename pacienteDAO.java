import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para ejecutar sentencias SQL precompiladas

public class pacienteDAO {
    private Connection connection;

    public pacienteDAO() {
        try {
            connection = conexion_base.conexion();
            System.out.println("Conectado desde pacienteDAO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // crear paciente
    public void insertarPaciente(paciente pac) throws SQLException {
        String sql = "INSERT INTO paciente (dni, edad, nombre, apellido, telefono, obra_social, domicilio, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, pac.getDni());
        stmt.setInt(2, pac.getEdad());
        stmt.setString(3, pac.getNombre());
        stmt.setString(4, pac.getApellido());
        stmt.setString(5, pac.getTelefono());
        stmt.setString(6, pac.getObra_social());
        stmt.setString(7, pac.getDomicilio());
        stmt.setDate(8, java.sql.Date.valueOf(pac.getFecha_nacimiento()));
        stmt.executeUpdate();
    }

}
