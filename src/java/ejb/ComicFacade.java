/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Comic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author bonetti
 */
@Stateless
public class ComicFacade extends AbstractFacade<Comic> {

    @PersistenceContext(unitName = "HumilArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComicFacade() {
        super(Comic.class);
    }
    
    public List<Comic> ordenarFecha(){
        Query q= this.em.createQuery("SELECT c FROM Comic c ORDER BY c.fechaCreacion DESC");
         List<Comic> lista = (List<Comic>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        } 
    }
    public List<Comic> ordenarAlfabetico(){
        Query q = this.em.createQuery("SELECT c FROM Comic c ORDER BY c.nombre ");
         List<Comic> lista = (List<Comic>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        }
    }
    
    public List<Comic> buscarFecha (Date d){
        Query q=this.em.createQuery("Select c from Comic c where c.fechaCreacion >= :fecha");
        q.setParameter("fecha", d);
        return q.getResultList();
    }
    public List<Comic> buscarNombre(String nombre){    
        Query q= this.em.createQuery("SELECT c from Comic c where c.nombre LIKE :nombre");
        q.setParameter("nombre","%"+ nombre+"%");
        List<Comic> lista = (List<Comic>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        }
    }
    
    public List<Comic> ordenarPorEntregas(){
       Query q= this.em.createQuery("select c from Comic c order by (select count(e.idComic) from Entrega e where e.idComic=c.idComic)");
        List<Comic> lista = (List<Comic>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        }  
    }
    
}
