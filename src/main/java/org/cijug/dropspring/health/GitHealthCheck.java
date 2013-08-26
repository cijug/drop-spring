package org.cijug.dropspring.health;

import com.yammer.metrics.core.HealthCheck;

public class GitHealthCheck extends HealthCheck {

    private final String gitServer;

    public GitHealthCheck(String gitServer) {
        super("git-server");
        this.gitServer = gitServer;
    }

    protected Result check() throws Exception {
        if (gitServer.equals("okay")) {
            return Result.healthy();
        }

        return Result.unhealthy("Unable to talk to Git Server");
    }

}
