package at.htl.control;

import at.htl.entity.Line;
import at.htl.entity.Location;
import at.htl.entity.Station;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StationRepository {

    @Inject
    LineRepository lineRepository;

    @Inject
    LocationRepository locationRepository;

    @Inject
    EntityManager em;

    @Transactional
    public Station save(Station station) {

        return em.merge(station);
    }


    /**
     * persist all stations from the List "stations" in the database
     *
     * @param lineName
     * @param stations
     */
    @Transactional
    public void saveStationsFromLine(String lineName, List<String> stations) {
        Station prevStation = null;
        for (String station : stations) {
            Line line = lineRepository.save(new Line(lineName));
            Location location = locationRepository.save(new Location(station));

            Station s = new Station(
                    line,
                    location,
                    prevStation
                    );

            prevStation = em.merge(s);;
        }
    }

    /**
     * find all stations per line in the database
     *
     * @param lineName
     * @return
     */
    public List<Station> stationsPerLine(String lineName) {
        List<Station> stations;

        Line l = lineRepository.save(new Line(lineName));

        if(l != null){
            TypedQuery<Station> query = em.createNamedQuery("Station.findByLineName",Station.class).setParameter("NAME", l.getName());
            stations = query.getResultList();
        } else {
            stations = null;
        }

        return stations;
    }

}
