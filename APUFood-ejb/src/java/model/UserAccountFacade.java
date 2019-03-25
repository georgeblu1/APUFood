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
public class UserAccountFacade extends AbstractFacade<UserAccount> {

    @PersistenceContext(unitName = "APUFood-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAccountFacade() {
        super(UserAccount.class);
    }
    
    public UserAccount SearchID(String id) {
        UserAccount fd = null;
        Query query = em.createNamedQuery("UserAccount.selectByID");
        query.setParameter("y", id);
        List<UserAccount> result = query.getResultList();
        for(Iterator it = result.listIterator(); it.hasNext();){
            fd = (UserAccount)it.next();
            break;
        }
        return fd;
    }
    public List searchByGender(char gender){
        Query query = em.createNamedQuery("UserAccount.findByGender");
        query.setParameter("x", gender);
        List<UserAccount> result = query.getResultList();
        System.out.println("DONE");
        return result;        
    }
}
