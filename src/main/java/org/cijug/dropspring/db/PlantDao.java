package org.cijug.dropspring.db;

import org.cijug.dropspring.core.Plant;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

public interface PlantDao extends Transactional<PlantDao> {

    @GetGeneratedKeys
    @SqlUpdate("insert into plants (name, size) values (:plant.name, :plant.size)")
    long create(@BindBean("plant") Plant plant);

}