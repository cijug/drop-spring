package org.cijug.dropspring;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;
import org.cijug.dropspring.web.BlogResource;

public class BlogService extends Service<BlogConfiguration> {

    public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.setName("foo");
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    public void run(BlogConfiguration blogConfiguration, Environment environment) throws Exception {
        environment.addResource(new BlogResource());
    }

    public static void main(String[] args) throws Exception {
        new BlogService().run(new String[] {"server", "foo.yml"});
    }

}
