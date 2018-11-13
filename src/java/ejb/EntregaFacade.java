/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Entrega;
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
public class EntregaFacade extends AbstractFacade<Entrega> {

    @PersistenceContext(unitName = "HumilArtPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntregaFacade() {
        super(Entrega.class);
    }
    
      public List<Entrega> ordenarFecha(){
        Query q= this.em.createQuery("SELECT e FROM Entrega e ORDER BY e.fechaCreacion ASC");
        List<Entrega> lista = (List<Entrega>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        } 
    }
      public List <Entrega> ordenarTamano(){
          Query q= this.em.createQuery("SELECT e FROM Entrega e ORDER BY LENGTH(e.archivo)");
          List<Entrega> lista = (List<Entrega>)q.getResultList();
          if(lista.isEmpty()){
            return new ArrayList<>();
          }else{
            return lista;
          }
      }
      
      public List<Entrega> filtrarPorFecha(Date fecha){
          Query q= this.em.createQuery("SELECT e FROM Entrega e where e.fechaCreacion > :fecha");
          q.setParameter("fecha", fecha);
          List<Entrega> lista = (List<Entrega>)q.getResultList();
          if(lista.isEmpty()){
            return new ArrayList<>();
          }else{
            return lista;
          } 
      }
      
    
}
