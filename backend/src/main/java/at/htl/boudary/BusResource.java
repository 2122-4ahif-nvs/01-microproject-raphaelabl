package at.htl.boudary;

import at.htl.control.BusRepository;
import at.htl.entity.Bus;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bus")
public class BusResource {

    @Inject
    BusRepository busRepository;

    @Inject
    Logger LOG;

//    @CheckedTemplate
//    public static class Templates{
//        public static native TemplateInstance bus(Bus bus);
//    }

    @Inject
    Template bus;


    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@PathParam("id") int id){

        Bus b = busRepository.findById((long) id);

        return bus.data("bus", b);

    }

}