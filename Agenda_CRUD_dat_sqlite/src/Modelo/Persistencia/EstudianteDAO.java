package Modelo.Persistencia;
import Modelo.Estudiante;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Sergio Castro
 */
public class EstudianteDAO {
    Conector con = new Conector();
    private Archivo archivo;
    private File file;
    public EstudianteDAO(Archivo arch){
        archivo = arch;
    }
    public String verEstudiante(File file) throws IOException{
        ArrayList<Estudiante>Estudiantes = archivo.leerArchivo(file);
        String texto = "";
        for(int i = 0; i < Estudiantes.size(); i++){
            texto = texto.concat(Estudiantes.get(i)+"\n");
        }
        return texto;
    }
    
    public Estudiante buscarEstudiante(String correo_Institucional, ArrayList<Estudiante>Estudiantes){
        Estudiante encontrado = null;
        if(!Estudiantes.isEmpty()){
            for(int i = 0; i<Estudiantes.size(); i++){
                if(Estudiantes.get(i).getCorreo_Institucional().equals(correo_Institucional)){
                    encontrado = Estudiantes.get(i);
                }
            }
        }return encontrado;
    }
    
    public boolean agregarEstudiante(String nombres, String apellidos, String fecha_Nacimiento, String correo_Institucional, String correo_Personal, long telefono_Celular, long telefono_fijo, String programa_Academico, ArrayList<Estudiante>Estudiantes, File file) throws IOException{
        Estudiante nuevo = new Estudiante(nombres,apellidos,fecha_Nacimiento,correo_Institucional,correo_Personal,telefono_Celular,telefono_fijo,programa_Academico);
        if(buscarEstudiante(correo_Institucional,Estudiantes) == null){
            Estudiantes.add(nuevo);
            archivo.escribirEnArchivo(Estudiantes, file);
            con.connect();
            con.saveEstudiante(nuevo);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean eliminarEstudiante(String correo_Institucional, ArrayList<Estudiante>Estudiantes, File file){
        boolean resp = false;
        try{
            Estudiante e = buscarEstudiante(correo_Institucional,Estudiantes);
            if(e != null){
                Estudiantes.remove(e);
                file.delete();
                file.createNewFile();
                archivo.escribirEnArchivo(Estudiantes, file);
                con.connect();
                con.deleteEstudiante(e);
                resp = true;
            }
        }catch(IOException e1){
            e1.printStackTrace();
        }
        return resp;
    }
}
