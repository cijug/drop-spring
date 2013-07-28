package org.cijug.dropspring;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;
import org.cijug.dropspring.web.FooResource;

public class FooService extends Service<FooConfiguration> {

    public void initialize(Bootstrap<FooConfiguration> bootstrap) {
        bootstrap.setName("foo");
        bootstrap.addBundle(new ViewBundle());
    }

    public void run(FooConfiguration fooConfiguration, Environment environment) throws Exception {
        environment.addResource(new FooResource());
    }

    public static void main(String[] args) throws Exception {
        new FooService().run(args);
    }

}
