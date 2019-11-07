/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import db.TMMaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matsuirie
 */
@Stateless
public class TMMasterFacade extends AbstractFacade<TMMaster> {
    
    @PersistenceContext(unitName = "20170303masterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMMasterFacade() {
        super(TMMaster.class);
    }
    
}
