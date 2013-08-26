package org.cijug.dropspring.db;

import org.cijug.dropspring.core.Pakage;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PakageMapper implements ResultSetMapper<Pakage> {

    public Pakage map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Pakage(r.getString("name"), r.getString("url"));
    }

}
