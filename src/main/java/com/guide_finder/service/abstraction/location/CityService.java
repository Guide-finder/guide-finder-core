package com.guide_finder.service.abstraction.location;


import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.util.List;

public interface CityService {

    List<City> getAllCitiesByCounttry(long country_id);

}
