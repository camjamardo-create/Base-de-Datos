import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para ejecutar sentencias SQL precompiladas
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;


public class agendaDAO {
    private Connection connection;

    public agendaDAO() {
        try {
            connection = conexion_base.conexion();
            System.out.println("Conectado desde agendaDAO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // leer agendas
    public List<agenda> obtenerAgendas() {
        List<agenda> agendas = new ArrayList<>();
        String sql = "SELECT * FROM agenda";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id_agenda = rs.getInt("id_agenda");
                int id_medico = rs.getInt("id_medico");
                agenda ag = new agenda(id_agenda, id_medico);
                agendas.add(ag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendas;
    }


}
