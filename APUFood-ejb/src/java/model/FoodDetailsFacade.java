/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author George
 */
@Stateless
public class FoodDetailsFacade extends AbstractFacade<FoodDetails> {

    @PersistenceContext(unitName = "APUFood-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoodDetailsFacade() {
        super(FoodDetails.class);
    }

    public FoodDetails SearchID(String id) {
        FoodDetails fd = null;
        Query query = em.createNamedQuery("FoodDetails.selectByID");
        query.setParameter("y", id);
        List<FoodDetails> result = query.getResultList();
        for(Iterator it = result.listIterator(); it.hasNext();){
            fd = (FoodDetails)it.next();
            break;
        }
        return fd;
    }

}
