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

    // Getters y Setters 

    public int getId_medico() {
        return id_medico;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
