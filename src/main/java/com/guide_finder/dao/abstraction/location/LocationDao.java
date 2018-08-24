package com.guide_finder.dao.abstraction.location;

import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.util.List;

/**
 * Created by stepanegorov on 24.08.18.
 */
public interface LocationDao {
    List<Country> getAllCountry();
    List<City> getAllCities();
    List<City> getCitiesByCountry();
}
