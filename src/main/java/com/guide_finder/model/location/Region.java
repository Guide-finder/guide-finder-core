package com.guide_finder.model.location;

import java.util.List;

public class Region extends AbstractLocation {

    private final Country country;

    private List<City> cities;

    public Region(String name ,Country country, List<City> cities) {
        super(name);
        this.country = country;
        this.cities = cities;
    }

    public Country getCountry() {
        return country;
    }
}
