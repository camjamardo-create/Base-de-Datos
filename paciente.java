import java.time.LocalDate;

public class paciente {
    private int dni;
    private int id_paciente;
    private int edad;
    private String nombre;
    private String apellido;
    private String telefono;
    private String obra_social;
    private String domicilio;
    private LocalDate fecha_nacimiento;
    
//getters y setters
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public int getId_paciente() {
        return id_paciente;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getObra_social() {
        return obra_social;
    }
    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    // Constructor
    public paciente(int dni, int id_paciente, int edad, String nombre, String apellido, String telefono, String obra_social, String domicilio, LocalDate fecha_nacimiento) {
        this.dni = dni;
        this.id_paciente = id_paciente;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.obra_social = obra_social;
        this.domicilio = domicilio;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
}


