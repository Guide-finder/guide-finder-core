package com.guide_finder.service.abstraction.location;

import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.util.List;

public interface LocationService {
    List<Country> getAllCountries();
    List<City> getCitiesByCountry(Country country);
    List<City> getCitiesByCountryId(Long id);
    public int getCoordsCount();
}
