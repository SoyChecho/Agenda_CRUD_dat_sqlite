package Modelo.Persistencia;

import Modelo.Estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio Castro
 */
public class Conector {
        //invocar clase computador del paquete modelo
    private Estudiante estudiantes;
    String url = "C:\\Users\\Sergio Castro\\Desktop\\Project\\bd_estudiantes.db";
    Connection connect;
    
        
    public void connect(){
        try{
            //variable connect para conectarme a la url de arriba
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            //si la conexion es difeneten de null = esta conectada
            if (connect != null){
                //System.out.println("Conectado");
            }
        }catch (SQLException ex){
            System.err.println("No se ha podido conectar la base de datos\n"+ex.getMessage());
        }
    }
    //cerrar la conexion
    public void close(){
        try{
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar la BD\n"+ex.getMessage());
        }
    }
    
    //Guardar informacion
    public void saveEstudiante(Estudiante estudiantes){
        try{
            //PreparedStattment permite una variable para insertar la informacion de acuerdo a los metos get set
            PreparedStatement st = connect.prepareStatement("INSERT INTO estudiantes (nombres,apellidos,fecha_Nacimiento,correo_Institucional,correo_Personal,telefono_Celular,telefono_fijo,programa_Academico) values (?,?,?,?,?,?,?,?)");
            st.setString(1, estudiantes.getNombres());
            st.setString(2, estudiantes.getApellidos());
            st.setString(3, estudiantes.getFecha_Nacimiento());
            st.setString(4, estudiantes.getCorreo_Institucional());
            st.setString(5, estudiantes.getCorreo_Personal());
            st.setLong(6, estudiantes.getTelefono_Celular());
            st.setLong(7, estudiantes.getTelefono_fijo());
            st.setString(8, estudiantes.getPrograma_Academico());
            st.execute();
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
    public void mostrarEstudiante(){
        //ResultSet metodo de la librerial; 
        ResultSet result = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from estudiantes");
            //st.executeQuery = ejecute la busqueda
            result = st.executeQuery();
            while(result.next()){
                System.out.println("Nombres: ");
                System.out.println(result.getString("nombres"));
                
                System.out.println("Apellidos: ");
                System.out.println(result.getString("apellidos"));
                
                System.out.println("Fecha de Nacimiento: ");
                System.out.println(result.getString("fecha_Nacimiento"));
                                
                System.out.println("Correo Institucional: ");
                System.out.println(result.getString("correo_Institucional"));
                                
                System.out.println("Correo Personal: ");
                System.out.println(result.getString("correo_Personal"));
                                
                System.out.println("Teléfono Celular: ");
                System.out.println(result.getString("telefono_Celular"));
                                
                System.out.println("Teléfono Fijo: ");
                System.out.println(result.getString("telefono_fijo"));
                                
                System.out.println("Programa Academico: ");
                System.out.println(result.getString("programa_Academico"));
                
                System.out.println("===========================");
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteEstudiante(Estudiante estudiantes){
        try{
            PreparedStatement st = connect.prepareStatement("DELETE FROM estudiantes WHERE correo_Institucional = ?");
            st.setString(1, estudiantes.getCorreo_Institucional());
            System.out.println("Estudiante Eliminado");
            st.execute();
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    //Crear metodos para cada consulta de la base de datos
    
    //Dato el correo mostrar datos del estudiante
    
        
    public void datosCorreo(){
        //ResultSet metodo de la librerial; 
        ResultSet result = null;
        try{
            PreparedStatement st = connect.prepareStatement("SELECT FROM estudiantes WHERE correo_Institucional = ?");
            //st.executeQuery = ejecute la busqueda
            result = st.executeQuery();
            while(result.next()){
                System.out.println("Nombres: ");
                System.out.println(result.getString("nombres"));
                
                System.out.println("Apellidos: ");
                System.out.println(result.getString("apellidos"));
                
                System.out.println("Fecha de Nacimiento: ");
                System.out.println(result.getString("fecha_Nacimiento"));
                                
                System.out.println("Correo Institucional: ");
                System.out.println(result.getString("correo_Institucional"));
                                
                System.out.println("Correo Personal: ");
                System.out.println(result.getString("correo_Personal"));
                                
                System.out.println("Teléfono Celular: ");
                System.out.println(result.getString("telefono_Celular"));
                                
                System.out.println("Teléfono Fijo: ");
                System.out.println(result.getString("telefono_fijo"));
                                
                System.out.println("Programa Academico: ");
                System.out.println(result.getString("programa_Academico"));
                
                System.out.println("===========================");
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    /*public void datosCorreo(){

        try{
            PreparedStatement st = connect.prepareStatement("SELECT FROM estudiantes WHERE correo_Institucional = ?");
            st.setString(1, estudiantes.getCorreo_Institucional());
            System.out.println("Datos Estudiantes Segun Correo Institucional");
            st.execute();

        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }*/
    //Dado los apellidos de un estudiante, se deben mostrar los datos de los estudiantes que tengan esos apellidos.
    public void datosApellidos (Estudiante estudiantes){
        try{
            PreparedStatement st = connect.prepareStatement("SELECT FROM estudiantes WHERE apellidos = ?");
            st.setString(1, estudiantes.getApellidos());
            System.out.println("Datos Estudiantes Segun Apellido");
            st.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    //Dado un programa, se deben mostrar los nombres y apellidos de los estudiantes que pertenecen a ese programa.
    public void datosPrograma (Estudiante estudiantes){
        try{
            PreparedStatement st = connect.prepareStatement("SELECT nombres,apellidos FROM estudiantes WHERE programa_Academico = ?");
            st.setString(1, estudiantes.getPrograma_Academico());
            System.out.println("Datos Estudiantes Segun Programa Academico");
            st.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
    //Dado un programa, se debe mostrar la cantidad de estudiantes que tiene ese programa
    public void cantidadPrograma(){
        try{
            PreparedStatement st = connect.prepareStatement("SELECT count FROM estudiantes WHERE programa_Academico = ?");
            st.setString(1, estudiantes.getPrograma_Academico());
            System.out.println("Cantidad estudiantes segun programa academico");
            st.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
    //Dado la fecha de nacimiento, se debe mostrar los datos de los estudiantes que nacieron en dicha fecha
    public void datosFechaNacimiento(){
        try{
            PreparedStatement st = connect.prepareStatement("SELECT FROM estudiantes WHERE fecha_Nacimiento = ?");
            st.setString(1, estudiantes.getFecha_Nacimiento());
            System.out.println("Cantidad estudiantes segun programa academico");
            st.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
    //Dado el número de celular de un estudiante, mostrar el nombre y programa del estudiante el cual tengan registrado dicho número.
    public void datosCelular(){
        try{
            PreparedStatement st = connect.prepareStatement("SELECT nombres,programa_Academico FROM estudiantes WHERE telefono_Celular = ?");
            st.setLong(1, estudiantes.getTelefono_Celular());
            System.out.println("Cantidad estudiantes segun programa academico");
            st.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }


    
}
