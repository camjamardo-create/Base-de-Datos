public class medico {       // Definimos atributos
    private int id_medico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private int DNI;
    private String contraseña;

    // Constructor
    public medico(int id_medico, String nombre, String apellido, String especialidad, int DNI, String contraseña) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.DNI = DNI;
        this.contraseña = contraseña;
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

    public int getDni() {
        return DNI;
    }
    public String getContraseña() {
        return contraseña;
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

    public void setDni(int dni) {
        this.DNI = DNI;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}



