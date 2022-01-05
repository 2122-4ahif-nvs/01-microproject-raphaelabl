package at.htl.boudary;

import at.htl.control.BusRepository;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

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

        return bus.data("bus", busRepository.findById(Long.parseLong(String.valueOf(id))));

    }

}