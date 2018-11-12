/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Javier Boned.
package ejb;

import entity.Entrega;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
