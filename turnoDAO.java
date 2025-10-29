import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para ejecutar sentencias SQL precompiladas
import java.time.LocalDateTime;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


public class turnoDAO {
    private Connection connection;

    // conectamos a la base de datos
    public turnoDAO() {
        try {
            connection = conexion_base.conexion();
            System.out.println("Conectado desde turnoDAO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // crear turno
    public void crearTurno(turno tur) throws SQLException {
        String sql = "INSERT INTO turno (id_turno, estado, fecha, consultorio, id_paciente, id_medico, id_agenda) VALUES (?, ?, ?, ?, ?, ?, ?)";
         
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, tur.getId_turno());
        stmt.setString(2, tur.getEstado());
        stmt.setTimestamp(3, java.sql.Timestamp.valueOf(tur.getFecha()));
        stmt.setString(4, tur.getConsultorio());
        stmt.setInt(5, tur.getId_paciente());
        stmt.setInt(6, tur.getId_medico());
        stmt.setInt(7, tur.getId_agenda());
        stmt.executeUpdate();
    }

    // leer turnos
    public List<turno> obtenerTurnos() {
        List<turno> turnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM turno";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id_turno = rs.getInt("id_turno");
                    String estado = rs.getString("estado");
                    LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
                    String consultorio = rs.getString("consultorio");
                    int id_paciente = rs.getInt("id_paciente");
                    int id_medico = rs.getInt("id_medico");
                    int id_agenda = rs.getInt("id_agenda");
                    turno tur = new turno(id_turno, estado, consultorio, fecha, id_paciente, id_medico, id_agenda);
                    turnos.add(tur);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace(); 
        }
        return turnos;
    } 
    
    
    // actualizar turno
    public void actualizarTurno(turno tur) throws SQLException {
        String sql = "UPDATE turno SET estado=?, fecha=?, consultorio=?, id_paciente=?, id_medico=?, id_agenda=? WHERE id_turno=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, tur.getEstado());
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(tur.getFecha()));
        stmt.setString(3, tur.getConsultorio());
        stmt.setInt(4, tur.getId_paciente());
        stmt.setInt(5, tur.getId_medico());
        stmt.setInt(6, tur.getId_agenda());
        stmt.setInt(7, tur.getId_turno());
        stmt.executeUpdate();
    }
    // eliminar turno
    public void eliminarTurno(int id_turno) throws SQLException {
        String sql = "DELETE FROM turno WHERE id_turno=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_turno);
        stmt.executeUpdate();
    }
    // cerrar conexion
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada desde turnoDAO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}    
