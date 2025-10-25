import java.time.LocalDateTime;

public class turno {
    private int id_turno;
    private String estado;
    private String consultorio;
    private LocalDateTime fecha;

    // claves foraneas
    private int id_paciente;
    private int id_medico;
    private int id_agenda;

    // asociaciones 
    private paciente paciente;
    private medico medico;
    private agenda agenda;

    //getters y setters
    public int getId_turno() {
        return id_turno;
    }
    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
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
    public medico getMedico() {
        return medico;
    }
    public void setMedico(medico medico) {
        this.medico = medico;
    }
    public agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(agenda agenda) {
        this.agenda = agenda;
    }
    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public int getId_medico() {
        return id_medico;
    }
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
    public int getId_agenda() {
        return id_agenda;
    }
    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    // constructor 
    public turno(int id_turno, String estado, String consultorio, LocalDateTime fecha, int id_paciente, int id_medico, int id_agenda) {
        this.id_turno = id_turno;
        this.estado = estado;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_agenda = id_agenda;
    }

}



