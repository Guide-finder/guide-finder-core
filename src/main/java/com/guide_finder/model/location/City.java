package com.guide_finder.model.location;

public class City extends AbstractLocation {

    private Region region;

    public City(String name, Region region) {
        super(name);
        this.region = region;
    }

    public AbstractLocation getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
