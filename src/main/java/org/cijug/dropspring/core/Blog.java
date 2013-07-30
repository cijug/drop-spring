package org.cijug.dropspring.core;

import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static java.lang.String.format;

@XmlRootElement
public class Blog implements Serializable {

//    @NotEmpty
    private String name;

//    @NotEmpty
    private String description;

    public Blog() {

    }

    public Blog(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return format("%s (%s)", name, description);
    }
}
