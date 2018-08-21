package com.guide_finder.model.location;

import java.util.LinkedList;
import java.util.List;

public class Country extends AbstractLocation {

    private List<Region> regions;

    public Country(String name, List<Region> regions) {
        super(name);
        this.regions = regions;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
