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
public class StaffDetailsFacade extends AbstractFacade<StaffDetails> {

    @PersistenceContext(unitName = "APUFood-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffDetailsFacade() {
        super(StaffDetails.class);
    }
    
    public StaffDetails SearchID(String id) {
        StaffDetails fd = null;
        Query query = em.createNamedQuery("StaffDetails.selectByID");
        query.setParameter("y", id);
        List<StaffDetails> result = query.getResultList();
        for(Iterator it = result.listIterator(); it.hasNext();){
            fd = (StaffDetails)it.next();
            break;
        }
        return fd;
    }
    
        public StaffDetails ReservationOnly() {
        StaffDetails fd = null;
        Query query = em.createNamedQuery("StaffDetails.selectByStatus");
        //query.setParameter("y", id);
        List<StaffDetails> result = query.getResultList();
        for(Iterator it = result.listIterator(); it.hasNext();){
            fd = (StaffDetails)it.next();
            break;
        }
        return fd;
    }
        
        public List searchByGender(char gender){
        Query query = em.createNamedQuery("StaffDetails.findByGender");
        query.setParameter("x", gender);
        List<UserAccount> result = query.getResultList();
        System.out.println("DONE");
        return result;        
    }
    
}
