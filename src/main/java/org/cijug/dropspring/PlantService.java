package org.cijug.dropspring;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.views.ViewBundle;
import org.cijug.dropspring.db.PlantDao;
import org.cijug.dropspring.web.PlantResource;
import org.skife.jdbi.v2.DBI;

public class PlantService extends Service<PlantConfiguration> {

    public void initialize(Bootstrap<PlantConfiguration> bootstrap) {
        bootstrap.setName("foo");
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    public void run(PlantConfiguration config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabase(), "postgresql");
        final PlantDao dao = jdbi.onDemand(PlantDao.class);

        environment.addResource(new PlantResource(dao));
    }

    public static void main(String[] args) throws Exception {
        new PlantService().run(new String[] {"server", "foo.yml"});
    }

}
