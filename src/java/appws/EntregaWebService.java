/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appws;

import ejb.ComicFacade;
import ejb.EntregaFacade;
import entity.Comic;
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
    private ComicFacade comicFacade;

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
    public void remove(@WebParam(name = "entity") Integer entity) {
        Entrega e = ejbRef.find(entity);
        ejbRef.remove(e);
    }

    @WebMethod(operationName = "findID")
    public Entrega find(@WebParam(name = "id") Integer id) {
        Entrega entrega = ejbRef.find(id);
        return entrega;
    }

    @WebMethod(operationName = "findAll")
    public List<Entrega> findAll() {
        return (List<Entrega>)ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Entrega> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
      @WebMethod(operationName="findByFechaDesc")
    public List<Entrega> findByFechaDesc(@WebParam(name = "idComic") Integer idComic){
        Comic c= comicFacade.find(idComic);
        return ejbRef.ordenarFecha(c);
    }
    
    @WebMethod(operationName="orderInversoNombre")
    public List<Entrega> orderInversoNombre(@WebParam(name = "idComic") Integer idComic){
        Comic c= comicFacade.find(idComic);
        return ejbRef.ordenarNombreInverso(c);
    }
    @WebMethod(operationName = "filtrarPorFecha")
    public List<Entrega> filtrarPorFecha(@WebParam(name = "fecha") Date fecha, @WebParam(name = "comic") Integer   comic) {
        Comic c = comicFacade.find(comic);
        return ejbRef.filtrarPorFecha(fecha,c);
    }
    
    @WebMethod(operationName = "addEntrega")
    public void addEntrega(@WebParam(name = "nombre") String nombre,@WebParam(name = "archivo") String archivo,@WebParam(name = "idComic") int idComic) {
        Comic comic;
        comic = comicFacade.find(idComic);
        Entrega entrega = new Entrega(nombre,archivo);
        entrega.setIdComic(comic);
        ejbRef.create(entrega);
    }
    
     @WebMethod(operationName = "editEntrega")
    public void editEntrega(@WebParam(name = "entrega") Integer entrega,@WebParam(name = "nuevoNombre") String nuevoNombre) {
        Entrega nuevaEntrega= ejbRef.find(entrega);
        nuevaEntrega.setNombre(nuevoNombre);
        ejbRef.edit(nuevaEntrega);
    } 
}
