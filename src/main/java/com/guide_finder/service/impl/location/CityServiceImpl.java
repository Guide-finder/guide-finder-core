package com.guide_finder.service.impl.location;

import com.guide_finder.dao.abstraction.location.CityDao;
import com.guide_finder.dao.abstraction.location.CountryDao;
import com.guide_finder.dao.impl.location.CityDaoImpl;
import com.guide_finder.dao.impl.location.CountryDaoImpl;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.location.CityService;
import com.guide_finder.service.abstraction.location.CountryService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    public CityServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.cityDao = new CityDaoImpl(connection);
    }

    @Override
    public List<City> getAllCitiesByCounttry(long country_id) {
        return cityDao.getAllCitiesByCountry(country_id);
    }
}
