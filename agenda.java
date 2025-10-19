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

    // Getters y Setters para leer los atributos privados de la clase desde fuera de ella, y
    // poder modificarlos si es necesario
    
    public int getId_agenda() {
        return id_agenda;
    }

    public LocalDateTime getfecha(){
        return fecha;
    }

    public boolean getfecha_libre(){
        return fecha_libre;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public void setfecha(LocalDateTime fecha){
        this.fecha = fecha;
    }

    public void setfecha_libre(boolean fecha_libre){
        this.fecha_libre = fecha_libre;
    }
}

