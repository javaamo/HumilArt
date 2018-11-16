/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Comic;
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
    
      public List<Entrega> ordenarFecha(Comic c){
        Query q= this.em.createQuery("SELECT e FROM Entrega e WHERE e.idComic =:comic ORDER BY e.fechaCreacion ASC");
        q.setParameter("comic", c);
        List<Entrega> lista = (List<Entrega>)q.getResultList();
        if(lista.isEmpty()){
            return new ArrayList<>();
        }else{
            return lista;
        } 
    }
      public List <Entrega> ordenarNombreInverso(Comic c){
          Query q= this.em.createQuery("SELECT e FROM Entrega e WHERE e.idComic =:comic ORDER BY e.nombre DESC ");
         q.setParameter("comic", c);
          List<Entrega> lista = (List<Entrega>)q.getResultList();
          if(lista.isEmpty()){
            return new ArrayList<>();
          }else{
            return lista;
          }
      }
      
      public List<Entrega> filtrarPorFecha(Date fecha, Comic c){
          Query q= this.em.createQuery("SELECT e FROM Entrega e where (e.fechaCreacion >= :fecha AND e.idComic =:comic)");
          q.setParameter("comic", c);
          q.setParameter("fecha", fecha);
          List<Entrega> lista = (List<Entrega>)q.getResultList();
          if(lista.isEmpty()){
            return new ArrayList<>();
          }else{
            return lista;
          } 
      }
      
      public List<Entrega> entregasPorComic(Comic comic){
          Query q = this.em.createQuery("SELECT e FROM Entrega e where e.idComic = :comic");
          q.setParameter("comic", comic);
           List<Entrega> lista = (List<Entrega>)q.getResultList();
          if(lista.isEmpty()){
            return new ArrayList<>();
          }else{
            return lista;
          } 
      }
    
}
