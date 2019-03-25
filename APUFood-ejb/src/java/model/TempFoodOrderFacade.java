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
public class TempFoodOrderFacade extends AbstractFacade<TempFoodOrder> {

    @PersistenceContext(unitName = "APUFood-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TempFoodOrderFacade() {
        super(TempFoodOrder.class);
    }
    public TempFoodOrder SearchID(String id) {
        TempFoodOrder fd = null;
        Query query = em.createNamedQuery("TempFoodOrder.selectByID");
        query.setParameter("y", id);
        List<TempFoodOrder> result = query.getResultList();
        for(Iterator it = result.listIterator(); it.hasNext();){
            fd = (TempFoodOrder)it.next();
            break;
        }
        return fd;
    }
    
    
    
}
