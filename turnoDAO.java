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
        String sql = "INSERT INTO turno (estado, fecha, consultorio, id_paciente, id_agenda, especialidad) VALUES (?, ?, ?, ?, ?, ?)";
         
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, tur.getEstado());
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(tur.getFecha()));
        stmt.setString(3, tur.getConsultorio());
        
        // Permitimos que el paciente sea nulo si el turno no esta ocupado
        if (tur.getId_paciente() != null) {
            stmt.setInt(4, tur.getId_paciente());
        } else {
            stmt.setNull(4, java.sql.Types.INTEGER);
        }

        stmt.setInt(5, tur.getId_agenda());
        stmt.setString(6, tur.getEspecialidad());
        stmt.executeUpdate();
    }

    // leer turnos
    public List<turno> obtenerTurnos() {
    List<turno> turnos = new ArrayList<>();

    // lo hacemos con una consulta sql directamente
    String sql = "SELECT t.*, a.id_medico, m.nombre AS med_nombre, m.apellido AS med_apellido, " +
                 "m.especialidad AS med_especialidad, m.dni AS med_dni, m.contrasena AS med_contrasena " +
                 "FROM turno t " +
                 "JOIN agendas a ON t.id_agenda = a.id_agenda " +
                 "JOIN medico m ON a.id_medico = m.id_medico";

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            // datos del turno
            int id_turno = rs.getInt("id_turno");
            String estado = rs.getString("estado");
            LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
            String consultorio = rs.getString("consultorio");
            Integer id_paciente = rs.getObject("id_paciente", Integer.class);
            int id_agenda = rs.getInt("id_agenda");
            String especialidad = rs.getString("especialidad");

            // datos del medico
            int id_med = rs.getInt("id_medico");
            String nombre = rs.getString("med_nombre");
            String apellido = rs.getString("med_apellido");
            String espMedico = rs.getString("med_especialidad");
            int dni = rs.getInt("med_dni");
            String contrasena = rs.getString("med_contrasena");

            // crear objetos
            medico med = new medico(id_med, nombre, apellido, espMedico, dni, contrasena);
            agendas ag = new agendas(id_agenda, id_med);
            ag.setMedico(med);
            turno tur = new turno(id_turno, estado, consultorio, fecha, id_paciente, id_agenda, especialidad);
            tur.setAgenda(ag);

            turnos.add(tur);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return turnos;
}

    
    
    // actualizar turno
    public void actualizarTurno(turno tur) throws SQLException {
        String sql = "UPDATE turno SET estado=?, fecha=?, consultorio=?, id_paciente=?, id_agenda=?, especialidad=? WHERE id_turno=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, tur.getEstado());
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(tur.getFecha()));
        stmt.setString(3, tur.getConsultorio());

        if (tur.getId_paciente() != null) {
            stmt.setInt(4, tur.getId_paciente());
        } else {
            stmt.setNull(4, java.sql.Types.INTEGER);
        }

        stmt.setInt(5, tur.getId_agenda());
        stmt.setString(6, tur.getEspecialidad());
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


