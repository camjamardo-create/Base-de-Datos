import java.time.LocalDateTime;

public class turno {
    private int id_turno;  
    private String estado;
    private String consultorio;
    private LocalDateTime fecha;
    private String especialidad;

    // claves foraneas
    private Integer id_paciente; // Para que acepte el null por si el turno esta libre
    private int id_agenda;

    // asociaciones 
    private paciente paciente;
    private agendas agenda;

    //getters y setters
    public int getId_turno() {
        return id_turno;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getConsultorio() {
        return consultorio;
    }
    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }

    public agendas getAgenda() {
        return agenda;
    }
    public void setAgenda(agendas agenda) {
        this.agenda = agenda;
    }
    public Integer getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_agenda() {
        return id_agenda;
    }
    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Agregamos para que desde turno podamos obtener los nombres de los medicos
    public String getNombreMedico() {
        return agenda.getMedico().getNombre();
    }


    // constructor 
    public turno(int id_turno, String estado, String consultorio, LocalDateTime fecha, Integer id_paciente, int id_agenda, String especialidad) {
        this.id_turno = id_turno;
        this.estado = estado;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.id_paciente = id_paciente;
        this.id_agenda = id_agenda;
        this.especialidad = especialidad;
    }

}





