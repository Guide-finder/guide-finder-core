package com.guide_finder.dao.abstraction.location;


import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.util.List;

public interface CityDao {

    List<City> getAllCitiesByCountry(long country_id);

}
