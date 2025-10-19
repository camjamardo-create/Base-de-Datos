import java.time.LocalDateTime;

public class agenda {
    private int id_agenda;
    private LocalDateTime fecha;
    private boolean fecha_libre;

    public agenda(int id_agenda, LocalDateTime fecha, boolean fecha_libre) {
        this.id_agenda = id_agenda;
        this.fecha = fecha;
        this.fecha_libre = fecha_libre;
    }
}
