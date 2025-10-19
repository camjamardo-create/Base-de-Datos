public class medico {       // Definimos atributos
    private int id_medico;
    private String nombre;
    private String apellido;
    private String especialidad;

    // Constructor
    public medico(int id_medico, String nombre, String apellido, String especialidad) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }
}
