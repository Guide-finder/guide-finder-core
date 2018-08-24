package com.guide_finder.model.location;

import com.guide_finder.util.TableAnnotation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@TableAnnotation(name = "country")
public class Country {

    private long id;
    private String name;

    public Country(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
