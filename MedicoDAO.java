import java.sql.*;  // Importa Connection, Statement, ResultSet, etc
import java.util.ArrayList;  
import java.util.List;  

import com.mysql.cj.x.protobuf.MysqlxSql;

public class MedicoDAO {
    
    // Create: Agrego un nuevo medico a la tabla de medicos de la BD
    public void agregarMedico(Medico medico) {
        String sql = "INSERT INTO Medico (id_medico, nombre, apellido, especialidad) VALUES (?,?,?,?)";
        // Ingresamos la primera fila a la tabla Medico de la BD, definiendo (?,?,?) como marcadores 
        // de posicion, para saber donde insertar los valores cuando prepareStatement los reemplace.
        // Esto es mas seguro que concatenar los valores directamente en el string SQL, ya que
        // previene inyecciones SQL.

        try {
            Connection conexion = conexion_base.getConexion(); // Abrimos la conexion con la BD
            PreparedStatement stmt = conexion.prepareStatement(sql); // Preparamos la consulta SQL (sql),
            // reemplazando los marcadores de posicion con los valores del objeto medico

            stmt.setInt(1,medico.getId_medico());  // Reemplazo los ? de cada posicion con el valor adecuadocon el id_medico
            stmt.setString(2,medico.getNombre());  
            stmt.setString(3,medico.getApellido());  
            stmt.setString(4,medico.getEspecialidad());  
            
            stmt.executeUpdate(); // Ejecuta la consulta SQL, es decir, ejecuta el INSERT de sql, 
            // modificando la BD. 

            System.out.println("Medico agregado exitosamente.");

            stmt.close(); // Cerramos el statement para desocupar los recursos 
            conexion.close(); // Cerramos la conexion con la BD
        }
        catch (SQLException e) {  // Si hay algun error en SQL lo mostrams 
            System.out.println("Error al agregar medico: " + e.getMessage());
        }
    }


    // READ: Leemos la lista de medicos ingresados
    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = new ArrayList<>(); // Creamos una lista vacia para guardar los resultados
        String sql = "SELECT * FROM Medico"; // Consulta SQL para seleccionar todos los medicos de la BD

        try {
            Connection conexion = conexion_base.getConexion(); 
            Statement stmt = conexion.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); // Ejecutamos la consulta y obtenemos el resultado
            // el comando executeQuery se usa para consultas SELECT que devuelven datos, que guardamos temporalmente en memoria 

            while (rs.next()) { // Recorremos el resultado fila por fila y obtenemos los datos
                int id_medico = rs.getInt("id_medico"); 
                String nombre = rs.getString("nombre"); 
                String apellido = rs.getString("apellido"); 
                String especialidad = rs.getString("especialidad"); 

                Medico medico = new Medico(id_medico, nombre, apellido, especialidad); // instanciamos un medico de la clase Medico
                medicos.add(medico); // Agregamos el medico a la lista
            }

            rs.close(); 
            stmt.close(); 
            conexion.close(); 
        }
        catch (SQLException e) { 
            System.out.println("Error al obtener medicos: " + e.getMessage());
        }

        return medicos; // Devolvemos la lista de medicos
    }


    // UPDATE: Actualizamos los datos de un medico existente
    public void actualizarMedico(Medico medico) {
        String sql = "UPDATE Medico SET nombre=?, apellido=?, especialidad=? WHERE id_medico=?";
        // Actualizamos los datos del medico con id_medico especifico
        
        try {
            Connection conexion = conexion_base.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            
            // Nuevos valores de los atributos
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getApellido());
            stmt.setString(3, medico.getEspecialidad());
            stmt.setInt(4, medico.getId_medico()); // Con esto colocamos el id del medico en la posicion 4 del SQL
            // del where, para saber que medico actualizar
            
            stmt.executeUpdate(); 
            System.out.println("Medico actualizado exitosamente.");

            stmt.close();
            conexion.close();
        }
        catch (SQLException e) {
            System.out.println("Error al actualizar medico: " + e.getMessage());
        }
    }


    // DELETE: Eliminamos un medico de la BD
    public void eliminarMedico(int id_medico) {
        String sql = "DELETE FROM Medico WHERE id_medico=?";

        try {
            Connection conexion = conexion_base.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id_medico); // Colocamos el id del medico a eliminar en la posicion 1 del SQL (o sea donde tenemos el ?)

            stmt.executeUpdate();  // Ejecutamos el DELETE
            System.out.println("Medico eliminado exitosamente.");   
            stmt.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar medico: " + e.getMessage());
        }
}

