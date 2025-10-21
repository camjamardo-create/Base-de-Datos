import java.sql.Connection;
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
        String sql = "INSERT INTO paciente (dni, nombre, apellido, domicilio, telefono, fecha_nac, obra_social, genero, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, pac.getDni());
        stmt.setString(2, pac.getNombre());
        stmt.setString(3, pac.getApellido());
        stmt.setString(4, pac.getDomicilio());
        stmt.setString(5, pac.getTelefono());
        stmt.setDate(6, java.sql.Date.valueOf(pac.getFecha_nacimiento()));
        stmt.setString(7, pac.getObra_social());
        stmt.setString(8, pac.getGenero());
        stmt.setString(9, pac.getContraseña());
        stmt.executeUpdate();
    }

}

