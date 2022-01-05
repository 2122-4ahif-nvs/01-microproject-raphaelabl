package at.htl.control;

import at.htl.entity.Bus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class BusRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Bus save(Bus b){
        return em.merge(b);
    }

    public Bus findById(Long id){

        try {
            TypedQuery<Bus> query = em.createQuery("select b from Bus b where b.busId = :ID", Bus.class)
                    .setParameter("ID", id);
            return query.getSingleResult();
        }catch(NoResultException e){
            Bus b = new Bus(0, "null", "null");
            b.busId = Long.getLong("0");
            return b;
        }
    }

}
