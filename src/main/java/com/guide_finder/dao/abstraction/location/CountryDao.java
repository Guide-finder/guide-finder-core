package com.guide_finder.dao.abstraction.location;


import com.guide_finder.model.category.Category;
import com.guide_finder.model.location.Country;

import java.util.List;

public interface CountryDao {

    List<Country> getAllCountries();

}
