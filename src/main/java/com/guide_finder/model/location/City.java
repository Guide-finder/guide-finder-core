package com.guide_finder.model.location;

import com.guide_finder.util.TableAnnotation;

import java.util.Objects;

@TableAnnotation(name = "city")
public class City {

    private long id;
    private String name;
    private String country;

    public City(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public City(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(String name) {
        this.name = name;
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
