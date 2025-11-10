
public class agendas {
    private int id_agenda;
    private int id_medico;
    private medico medico;

    public int getId_agenda() {
        return id_agenda;
    }
    public int getId_medico(){
        return id_medico;
    }
    public medico getMedico() { 
        return medico; 
    }
    public void setMedico(medico medico) { 
        this.medico = medico; 
    }
    
        public agendas(int id_agenda, int id_medico) {
        this.id_agenda = id_agenda;
        this.id_medico = id_medico;
    }
    

}

