package model.location;

import java.util.List;

public class Region extends AbstractLocation {

    private final Country country;
    private final List<City> cities;

    public Region() {
        country = null;
        cities = null;
    }

    public Country getCountry() {
        return country;
    }
}
