/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appws;

import ejb.EntregaFacade;
import entity.Entrega;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bonetti
 */
@WebService(serviceName = "EntregaWebService")
public class EntregaWebService {

    @EJB
    private EntregaFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Entrega entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Entrega entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Entrega entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Entrega find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Entrega> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Entrega> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
      @WebMethod(operationName="encontrarPorFechaDesc")
    public List<Entrega> findByFechaDesc(){
        return ejbRef.ordenarFecha();
    }
    
    @WebMethod(operationName="encontrarPorTamano")
    public List<Entrega> findByTamano(){
        return ejbRef.ordenarTamano();
    }
    @WebMethod(operationName = "filtrarPorFecha")
    public List<Entrega> filtrarPorFecha(@WebParam(name = "fecha") Date fecha) {
        return ejbRef.filtrarPorFecha(fecha);
    }
    
}
