package com.guide_finder.model.location;

public abstract class AbstractLocation {

    private long id;

    private String name;


    protected AbstractLocation(String name) {
        this.name = name;
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
}
