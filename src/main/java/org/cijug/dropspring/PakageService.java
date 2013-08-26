package org.cijug.dropspring;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.views.ViewBundle;
import com.yammer.metrics.jdbi.InstrumentedTimingCollector;
import com.yammer.metrics.reporting.ConsoleReporter;
import com.yammer.metrics.reporting.CsvReporter;
import org.cijug.dropspring.db.PakageDAO;
import org.cijug.dropspring.health.GitHealthCheck;
import org.cijug.dropspring.web.PakageResource;
import org.skife.jdbi.v2.DBI;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class PakageService extends Service<PakageConfiguration> {

    public static void main(String[] args) throws Exception {
        new PakageService().run(new String[] {"server", "pakage.yml"});
    }

    public void initialize(Bootstrap<PakageConfiguration> bootstrap) {
        bootstrap.setName("bower-registry");
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    public void run(PakageConfiguration config, Environment environment) throws Exception {
        final DBI jdbi = getDB(config, environment);
            jdbi.setTimingCollector(new InstrumentedTimingCollector());
        ConsoleReporter.enable(1, TimeUnit.MINUTES);

        final PakageDAO dao = jdbi.onDemand(PakageDAO.class);
        environment.addResource(new PakageResource(dao));
        environment.addHealthCheck(new GitHealthCheck(config.getGit()));
    }

    private DBI getDB(PakageConfiguration config, Environment environment) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabase(), "mysql");

        return jdbi;
    }

}
