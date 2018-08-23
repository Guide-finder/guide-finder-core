package com.guide_finder.model.location;

import com.guide_finder.util.TableAnnotation;

import java.util.Objects;

@TableAnnotation(name = "city")
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {

        return Objects.hash(region);
    }
}
