package org.cijug.dropspring.core;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static java.lang.String.format;

public class Pakage implements Serializable {

    @NotEmpty
    private String name;

    @Pattern(regexp=".*\\.git$")
    private String url;

    public Pakage() {

    }

    public Pakage(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
