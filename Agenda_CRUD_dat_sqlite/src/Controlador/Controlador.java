package Controlador;
import Modelo.Estudiante;
import Vista.VistaConsola;
import Modelo.EstudianteDTO;
import Modelo.Persistencia.Conector;
import java.io.IOException;
/**
 *
 * @author Sergio Castro
 */
public class Controlador {
    private VistaConsola vista;
    private EstudianteDTO student;
    Conector con = new Conector();
    
    
    public Controlador() throws IOException{
        vista = new VistaConsola();
        student = new EstudianteDTO();
        funcionar();
    }
    
    public void funcionar() throws IOException{
        
        int opcion = 0;
        
        String menu = "\n"+"INSTITUTO LA FLORESTA"+
                "\nSeleccione tarea a realizar:"+
                "\n"+"1.Ingresar estudiante"+
                "\n"+"2.Consultas"+
                "\n"+"3.Modificar estudiante"+
                "\n"+"4.Eliminar estudiante"+
                "\n"+"5.Ver directorio de estudiantes"+
                "\n"+"6.Salir"+
                "\nOpción:";
        do{
            opcion = vista.leerDatoEntero(menu);
            
            switch(opcion){
                case 1:
                    ingresarEstudiante();                
                    break;
                case 2:
                    Consultas();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    mostrarDirectorio();
                    break;
                case 6:
                    vista.imprimir("Hasta pronto");
                    break;
                default:
                    vista.imprimir("La opcion no es valida");
            }
        }while(opcion != 6);
    }
    
    
    public void ingresarEstudiante()throws IOException{
        String nom = "", ape = "", fecha = "", coIns= "", coPer = "", programa = "";
        long telCel = 0, telfijo = 0;
        vista.imprimir("\nIngresar estudiante");
        nom = vista.leerDatoString("Ingresar nombres:");
        ape = vista.leerDatoString("\nIngresar apellidos:");
        fecha = vista.leerDatoString("\nIngresar fecha de nacimiento (YYYY-MM-DD):");
        coIns = vista.leerDatoString("\nIngresar correo institucional:");
        coPer = vista.leerDatoString("\nIngresar correo personal:");
        telCel = vista.leerDatoLong("\nIngresar número de celular:");
        telfijo = vista.leerDatoLong("\nIngresar número fijo:");
        programa = vista.leerDatoString("\nIngresar programa:");
        
        if(student.getEstudianteDAO().agregarEstudiante(nom,ape,fecha,coIns,coPer,telCel,telfijo,programa,student.getEstudiantes(),student.getFile())){
            vista.imprimir("\nSe agregó el estudiante");
        }else{
            vista.imprimir("\nNo fue posible agregar el estudiante");  
        }
    }
    
        
    public void modificarEstudiante() throws IOException{
        String nom = "", ape = "", fecha = "", coIns= "", coPer = "", programa = "";
        long telCel = 0, telfijo = 0;
        vista.imprimir("\nModificar estudiante");
        coIns = vista.leerDatoString("Ingresar correo institucional");
        Estudiante rta = student.getEstudianteDAO().buscarEstudiante(coIns,student.getEstudiantes());
        if(rta != null){
            nom = vista.leerDatoString("Ingresar nombres:");
            ape = vista.leerDatoString("\nIngresar apellidos:");
            fecha = vista.leerDatoString("\nIngresar fecha de nacimiento (YYYY-MM-DD):");
            coIns = vista.leerDatoString("\nIngresar correo institucional:");
            coPer = vista.leerDatoString("\nIngresar correo personal:");
            telCel = vista.leerDatoLong("\nIngresar número de celular:");
            telfijo = vista.leerDatoLong("\nIngresar número fijo:");
            programa = vista.leerDatoString("Ingresar programa:");
            
            student.getEstudianteDAO().eliminarEstudiante(coIns,student.getEstudiantes(),student.getFile());
            student.getEstudianteDAO().agregarEstudiante(nom,ape,fecha,coIns,coPer,telCel,telfijo,programa,student.getEstudiantes(),student.getFile());
            vista.imprimir("Se modificó el estudiante");
        }else{
            vista.imprimir("\nEl estudiante no se encuentra registrado");
        }
    }
    
    public void eliminarEstudiante(){
        String coIns = "";
        vista.imprimir("\nEliminar estudiante");
        coIns = vista.leerDatoString("Ingresar correo institucional:");
        if(student.getEstudianteDAO().eliminarEstudiante(coIns,student.getEstudiantes(),student.getFile())){
            vista.imprimir("\nSe eliminó el estudiante");
        }else{
            vista.imprimir("El estudiante no se encuentra registrado");
        }
    }
    
    public void mostrarDirectorio() throws IOException{
        vista.imprimir("\nEl directorio de los estudiantes");
        //vista.imprimir(student.getEstudianteDAO().verEstudiante(student.getFile()));
        con.connect();
        con.mostrarEstudiante();
    }
    
    public void Consultas() throws IOException{
        
                
        int Subopcion = 0;
        
        String Submenu = "\nConsultas"+
		"\nSeleccione consulta a realizar:"+
		"\n1.Buscar estudiante por correo electrónico"+
		"\n2.Buscar estudiante por apellidos"+
		"\n3.Buscar por programa"+
		"\n4.Buscar cantidad de estudiantes por programa"+
		"\n5.Buscar por fecha de nacimiento"+
		"\n6.Buscar por número de celular"+
                "\n7.Vuelta al menú principal"+
		"\nOpción:";
        do{
            Subopcion = vista.leerDatoEntero(Submenu);
            
            switch(Subopcion){
                case 1:
                    datosCorreo();                
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    vista.imprimir("Vuelta al menu");
                    break;
                default:
                    vista.imprimir("La opcion no es valida");
            }
        }while(Subopcion != 7);
    }
        
    public void datosCorreo() throws IOException{
        //String coIns = "";
        vista.imprimir("\nBuscar estudiante por correo institucional");
        //coIns = vista.leerDatoString("Ingresar correo institucional:");
        //Estudiante rta = student.getEstudianteDAO().buscarEstudiante(coIns,student.getEstudiantes());
        //if( rta != null){
            vista.imprimir("\nInformación del estudiante");
            con.connect();
            con.datosCorreo();
            //vista.imprimir(rta.toString());
            
        //}else{
        //    vista.imprimir("El estudiante no se encuentra registrado");
        //}
    }
    
    


    
    
}
