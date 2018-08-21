package com.guide_finder.model.location;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Region extends AbstractLocation {

    private final Country country;

    private final City city;

    public Region(String name, Country country, City city) {
        super(name);
        this.country = country;
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(country, region.country) &&
                Objects.equals(city, region.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(country, city);
    }
}
