package Modelo;
import java.io.Serializable;
/**
 *
 * @author Sergio Castro
 */
public class Estudiante implements Serializable {
    protected String nombres;
    protected String apellidos;
    protected String fecha_Nacimiento;
    protected String correo_Institucional;
    protected String correo_Personal;
    protected long telefono_Celular;
    protected long telefono_fijo;
    protected String programa_Academico;

    public Estudiante(String nombres, String apellidos, String fecha_Nacimiento, String correo_Institucional, String correo_Personal, long telefono_Celular, long telefono_fijo, String programa_Academico) {
        super();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.correo_Institucional = correo_Institucional;
        this.correo_Personal = correo_Personal;
        this.telefono_Celular = telefono_Celular;
        this.telefono_fijo = telefono_fijo;
        this.programa_Academico = programa_Academico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getCorreo_Institucional() {
        return correo_Institucional;
    }

    public void setCorreo_Institucional(String correo_Institucional) {
        this.correo_Institucional = correo_Institucional;
    }

    public String getCorreo_Personal() {
        return correo_Personal;
    }

    public void setCorreo_Personal(String correo_Personal) {
        this.correo_Personal = correo_Personal;
    }

    public long getTelefono_Celular() {
        return telefono_Celular;
    }

    public void setTelefono_Celular(long telefono_Celular) {
        this.telefono_Celular = telefono_Celular;
    }

    public long getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(long telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getPrograma_Academico() {
        return programa_Academico;
    }

    public void setPrograma_Academico(String programa_Academico) {
        this.programa_Academico = programa_Academico;
    }
    
    @Override
    public String toString(){
        return "\nNombres: "+nombres+"\nApellidos: "+apellidos+"\nFecha Nacimiento: "+fecha_Nacimiento+
                "\nCorreo institucional: "+correo_Institucional+"\nCorreo personal: "+correo_Personal+
                "\nNúmero de teléfono celular: "+telefono_Celular+"\nNúmero de teléfono fijo: "+telefono_fijo+
                "\nPrograma académico: "+programa_Academico;
    }


    
    
}
