package org.cijug.dropspring.db;

import org.cijug.dropspring.core.Pakage;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import java.util.List;

@RegisterMapper(PakageMapper.class)
public abstract class PakageDAO implements Transactional<PakageDAO> {

    @GetGeneratedKeys
    @SqlUpdate("insert into packages (name, url) values (:pakage.name, :pakage.url)")
    public abstract long savePakage(@BindBean("pakage") Pakage pakage);

    @SqlQuery("select * from packages where name like :name")
    abstract List<Pakage> getPakages(@Bind("name") String name);

    @SqlQuery("select * from packages")
    public abstract List<Pakage> getAllPakages();

    public List<Pakage> getPakagesByName(String name) {
        return getPakages("%" + name + "%");
    }
}