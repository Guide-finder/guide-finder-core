package com.guide_finder.dao.abstraction.location;

import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.util.List;

public interface LocationDao {
    List<Country> getAllCountries();
    List<City> getAllCities();
    List<City> getCitiesByCountry(Country country);
    List<City> getCitiesByCountryId(Long id);
    int getCoordsCount();
}
