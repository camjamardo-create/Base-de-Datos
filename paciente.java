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
