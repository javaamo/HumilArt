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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bonetti
 */
@WebService(serviceName = "ComicWebService")
public class ComicWebService {

    @EJB
    private EntregaFacade entregaFacade;

    @EJB
    private ComicFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    
    
    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Comic entity) {
        ejbRef.create(entity);
    }
    
    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Comic entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Integer entity) {
        Comic c = ejbRef.find(entity);
        ejbRef.remove(c);
    }

    @WebMethod(operationName = "find")
    public Comic find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Comic> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Comic> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
    @WebMethod(operationName="encontrarPorFecha")
    public List<Comic> findByFecha(){
        return ejbRef.ordenarFecha();
    }
    
    @WebMethod(operationName="encontrarPorNombreAlfabetico")
    public List<Comic> findByNombre(){
        return ejbRef.ordenarAlfabetico();
    }
    
    @WebMethod(operationName = "buscarNombre")
    public List<Comic> buscarPorNombre(@WebParam(name = "nombre") String nombre) {
        return ejbRef.buscarNombre(nombre);
    }
    
    @WebMethod(operationName = "buscarPorNumEntrega")
    public List<Comic> buscarPorNumEntrega() {
        return ejbRef.ordenarPorEntregas();
    }
    
    @WebMethod(operationName = "addComic")
    public void addComic(@WebParam(name = "nombre") String nombre,@WebParam(name = "comentario") String comentario) {
        Comic nuevoComic= new Comic(nombre,comentario);
        ejbRef.create(nuevoComic);
    }
    
     @WebMethod(operationName = "editComic")
    public void editComic(@WebParam(name = "comic") Integer comic,@WebParam(name = "nuevoNombre") String nuevoNombre ,@WebParam(name = "nuevaDescripcion") String nuevaDescripcion  ) {
        Comic nuevoComic= ejbRef.find(comic);
        nuevoComic.setDescripcion(nuevaDescripcion);
        nuevoComic.setNombre(nuevoNombre);
        ejbRef.edit(nuevoComic);
        
    }
   @WebMethod(operationName = "findComicById") 
    public Comic findComicById(@WebParam(name="idComic") Integer idComic){
      return ejbRef.find(idComic);
    }
    
    @WebMethod(operationName="buscarPorFechaMayor")
    public List <Comic> buscarPorFechaMayor(Date d){
        return ejbRef.buscarFecha(d);
    }
    
    @WebMethod(operationName="getEntregasComic")
    public List<Entrega> entregasComic(@WebParam(name = "comic") Integer comic){
       Comic c= ejbRef.find(comic);
       List<Entrega> lista = entregaFacade.entregasPorComic(c);
       return lista;
    }
     
    

    
}
