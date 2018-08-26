package com.guide_finder.model.location;

import com.guide_finder.util.TableAnnotation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@TableAnnotation(name = "country")
public class Country extends AbstractLocation {

    private Region region;

    public Country(long id, String name, Region region) {
        super(id, name);
        this.region = region;
    }

    public Country(long id, String name) {
        super(id, name);
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
