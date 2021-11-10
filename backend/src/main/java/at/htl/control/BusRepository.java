package at.htl.control;

import at.htl.entity.Bus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BusRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Bus save(Bus b){
        return em.merge(b);
    }
}
