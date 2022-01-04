package at.htl.control;

import at.htl.entity.BusStop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BusStopRepository{

    @Inject
    EntityManager em;

    @Transactional
    public BusStop save(BusStop busStop) {

        return em.merge(busStop);

    }



}
