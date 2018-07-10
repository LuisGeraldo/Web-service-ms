package webservicecrud;

import controller.MateriaController;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "CrudMateriaWebService")
public class CrudMateriaWebService {
    MateriaController materia;
    
    public CrudMateriaWebService(){
        materia = new MateriaController();
    }
    
    
    @WebMethod(operationName = "Crear")
    public String Crear(@WebParam(name = "codigo") String codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
       
        if(materia.Crear(codigo, nombre, descripcion)){
           
           return "Materia creada";
           
        }else{
            
           return "Materia no ceeada";
        }
    }

    @WebMethod(operationName = "Buscar")
    public String Buscar(@WebParam(name = "codigo") String codigo) {
       
        String result = materia.Buscar(codigo);
        
        return result;
    }

  
    @WebMethod(operationName = "Borrar")
    public String Borrar(@WebParam(name = "codigo") String codigo) {
        
        if(materia.Borrar(codigo)){
            return "Materia borrada";
        
        }else{
        
            return "Materia no borrada";
        }
    }

   
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "codigo") String codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        
        if(materia.Actualizar(codigo, nombre, descripcion)){
            return "Materia actualizada";
    
        }else{
        
            return "Materia no actualizada";
        }
    }
}
