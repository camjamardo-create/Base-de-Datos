import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para ejecutar sentencias SQL precompiladas
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


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
    // leer pacientes
    public List<paciente> obtenerPacientes() {
        List<paciente> pacientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id_paciente = rs.getInt("id_paciente");
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");
                LocalDate fecha_nac = rs.getDate("fecha_nac").toLocalDate();
                String obra_social = rs.getString("obra_social");
                String genero = rs.getString("genero");
                String contrasena = rs.getString("contrasena");
                pacientes.add(new paciente(id_paciente, dni, nombre, apellido, domicilio, telefono, obra_social, fecha_nac, genero, contrasena));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // print stack trace on error sirve para imprimir el seguimiento de la pila en caso de error
        }   
        return pacientes;
    }
    //Actualizar pacientes
    public void actualizarPaciente(paciente pac) throws SQLException {
        String sql = "UPDATE paciente SET dni=?, nombre=?, apellido=?, domicilio=?, telefono=?, fecha_nac=?, obra_social=?, genero=?, contrasena=? WHERE id_paciente=?";
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
        stmt.setInt(10, pac.getId_paciente());
        stmt.executeUpdate();
    }
    // eliminar paciente
    public void eliminarPaciente(int id_paciente) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_paciente); // setInt para establecer el valor del parámetro id_paciente en la sentencia
        stmt.executeUpdate();
    }

    // cerrar conexion
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada desde pacienteDAO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






