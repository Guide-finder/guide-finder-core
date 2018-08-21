package com.guide_finder.model.location;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Country extends AbstractLocation {

    private Region region;

    public Country(String name, Region region) {
        super(name);
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(region, country.region);
    }

    @Override
    public int hashCode() {

        return Objects.hash(region);
    }
}
