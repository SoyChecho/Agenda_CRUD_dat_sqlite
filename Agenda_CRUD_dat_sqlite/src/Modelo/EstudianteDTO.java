package Modelo;
import Modelo.Persistencia.Archivo;
import Modelo.Persistencia.EstudianteDAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Sergio Castro
 */
public class EstudianteDTO {
    private Archivo archivo;
    private File file = new File("datos_estudiantes.dat");
    private EstudianteDAO estudianteDAO;
    private ArrayList<Estudiante>Estudiantes;
    
    public EstudianteDTO() throws IOException{
        Estudiantes = new ArrayList<Estudiante>();
        archivo = new Archivo(file);
        estudianteDAO = new EstudianteDAO(archivo);
        Estudiantes = archivo.leerArchivo(file);
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return Estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> Estudiantes) {
        this.Estudiantes = Estudiantes;
    }
    
    
}
