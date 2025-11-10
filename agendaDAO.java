
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class agendasDAO {
    private Connection connection;

    public agendasDAO() {
        try {
            connection = conexion_base.conexion();
            System.out.println("Conectado desde agendaDAO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener agenda por id
    public agendas obtenerAgenda(int id_agenda) {
        agendas ag = null;
        try {
            // Primero obtenemos la agenda
            String sqlAgenda = "SELECT * FROM agendas WHERE id_agenda = ?";
            PreparedStatement stmtAgenda = connection.prepareStatement(sqlAgenda);
            stmtAgenda.setInt(1, id_agenda);
            ResultSet rsAgenda = stmtAgenda.executeQuery();

            if (rsAgenda.next()) {
                int id_med = rsAgenda.getInt("id_medico");
                ag = new agendas(id_agenda, id_med);

                // Ahora traemos el médico correspondiente
                String sqlMedico = "SELECT * FROM medico WHERE id_medico = ?";
                PreparedStatement stmtMedico = connection.prepareStatement(sqlMedico);
                stmtMedico.setInt(1, id_med);
                ResultSet rsMedico = stmtMedico.executeQuery();

                if (rsMedico.next()) {
                    String nombre = rsMedico.getString("nombre");
                    String apellido = rsMedico.getString("apellido");
                    String especialidad = rsMedico.getString("especialidad");
                    int dni = rsMedico.getInt("dni");
                    String contrasena = rsMedico.getString("contrasena");

                    medico med = new medico(id_med, nombre, apellido, especialidad, dni, contrasena);
                    ag.setMedico(med);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ag == null) {
            System.out.println("No se encontró agenda con id: " + id_agenda);
        }
            return ag;

        }
}

