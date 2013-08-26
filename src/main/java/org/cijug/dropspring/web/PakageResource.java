package org.cijug.dropspring.web;

import com.yammer.metrics.annotation.Timed;
import org.cijug.dropspring.core.Pakage;
import org.cijug.dropspring.db.PakageDAO;
import org.cijug.dropspring.view.PakageView;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("packages")
public class PakageResource {

    private final PakageDAO dao;

    public PakageResource(PakageDAO dao) {
        this.dao = dao;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public PakageView showView() {
        List<Pakage> pakages = dao.getAllPakages();

        return new PakageView(pakages);
    }

    @GET
    @Timed
    @Path("search/{name}")
    public PakageView getPakagesByName(@PathParam("name") String name) {
        List<Pakage> pakages = dao.getPakagesByName(name);

        return new PakageView(pakages);
    }

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPakage(@Auth User user, @Valid Pakage pakage) {
        return "" + dao.savePakage(pakage);
    }

}
