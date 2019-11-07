package ejb;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import db.TMMaster;
import java.util.List;

/**
 *
 * @author WITC_NP02410A
 */
@Stateless
public class Db {
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(TMMaster tMMaster){
            em.persist(tMMaster);
    }
    
    public void update(TMMaster tMMaster){
        em.merge(tMMaster);
    }
    
    public TMMaster find(String key){
        return em.find(TMMaster.class,key);
    }
    
    public void delete(TMMaster tMMaster){
        em.remove(em.merge(tMMaster));
    }
    
    public List<TMMaster> getALL(){
         return em.createQuery("SELECT c FROM TMMaster c").getResultList();
    }

}
