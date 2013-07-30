package org.cijug.dropspring.web;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import org.cijug.dropspring.core.Blog;
import org.cijug.dropspring.view.BlogView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.concurrent.atomic.AtomicLong;

@Path("/blog")
//@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class BlogResource {

    private final AtomicLong counter;

    public BlogResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public BlogView getPost(@QueryParam("name") Optional<String> name) {
        long counter = this.counter.incrementAndGet();

        Blog blog = new Blog("Name: " + counter, "Description: " + counter);

        return new BlogView(blog);
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({"application/x-www-form-urlencoded", MediaType.APPLICATION_JSON})
    public String makePost(MultivaluedMap<String, String> params) {
        Blog blog = new Blog(params.getFirst("name"), params.getFirst("description"));

        System.out.println("blog = " + blog);

        return "" + this.counter.incrementAndGet();
    }

}
