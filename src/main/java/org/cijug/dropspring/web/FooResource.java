package org.cijug.dropspring.web;

import com.yammer.metrics.annotation.Timed;
import org.cijug.dropspring.core.Foo;
import org.cijug.dropspring.view.FooView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/foo")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class FooResource {

    private final AtomicLong counter;

    public FooResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public FooView sayHello(@QueryParam("name") com.google.common.base.Optional<String> name) {
        long counter = this.counter.incrementAndGet();

        Foo foo = new Foo("Name: " + counter, "Description: " + counter);

        return new FooView(foo);
    }

}
