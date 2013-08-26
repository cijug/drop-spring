package org.cijug.dropspring;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;
import org.skife.jdbi.v2.tweak.transactions.LocalTransactionHandler;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private DBI dbi;
    private static DB db;

    public static DB instance() {
        if (db == null) {
            db = new DB();
        }

        return db;
    }

    protected DB() {
        try {
            JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
            InputStream sql = this.getClass().getResourceAsStream("/test.sql");
            RunScript.execute(ds.getConnection(), new InputStreamReader(sql));

            dbi = new DBI(ds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T dao(Class<T> type) {
        T dao = dbi.open(type);

        return dao;
    }

    public DBI getDbi() {
        return dbi;
    }

}
