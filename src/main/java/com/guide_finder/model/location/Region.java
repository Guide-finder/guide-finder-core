package com.guide_finder.model.location;

import java.util.List;

public class Region extends AbstractLocation {

    private final Country country;

    private final List<City> cities;

    public Region() {
        super("null");
        country = null;
        cities = null;
    }

    public Country getCountry() {
        return country;
    }
}
