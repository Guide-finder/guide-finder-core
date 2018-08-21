package com.guide_finder.model.location;

public abstract class AbstractLocation {

    private final long id;

    private final String name;

    protected AbstractLocation() {
        id = 0;
        name = null;
    }
}
