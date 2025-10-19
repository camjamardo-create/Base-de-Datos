import java.time.LocalDateTime;

public class turno {
    private int id_turno;
    private String estado;
    private String consultorio;
    private LocalDateTime fecha;

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
    

}
