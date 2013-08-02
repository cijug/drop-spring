package org.cijug.dropspring.web;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import org.cijug.dropspring.core.Plant;
import org.cijug.dropspring.db.PlantDao;
import org.cijug.dropspring.view.PlantView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.concurrent.atomic.AtomicLong;

@Path("/blog")
//@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class PlantResource {

    private final PlantDao dao;
    private final AtomicLong counter;

    public PlantResource(PlantDao dao) {
        this.dao = dao;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public PlantView getPost(@QueryParam("name") Optional<String> name) {
        long counter = this.counter.incrementAndGet();

        Plant plant = new Plant("Name: " + counter, "Description: " + counter);

        return new PlantView(plant);
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({"application/x-www-form-urlencoded", MediaType.APPLICATION_JSON})
    public String makePost(MultivaluedMap<String, String> params) {
        Plant plant = new Plant(params.getFirst("name"), params.getFirst("description"));

        System.out.println("plant = " + plant);

        return "" + this.counter.incrementAndGet();
    }

}
