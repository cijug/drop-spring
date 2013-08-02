package org.cijug.dropspring;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class TestDatabase {

    private static TestDatabase db;
    private DataSource ds;

    public static TestDatabase getInstance() {
        if (db == null) {
            db = new TestDatabase();
        }

        return db;
    }

    protected TestDatabase() {
        try {
            ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
            InputStream sql = this.getClass().getResourceAsStream("/test.sql");
            RunScript.execute(ds.getConnection(), new InputStreamReader(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DBI getDBI() throws Exception {
        return new DBI(ds);
    }
}
