package com.guide_finder.service.impl.location;

import com.guide_finder.dao.abstraction.location.LocationDao;
import com.guide_finder.dao.impl.category.CategoryDaoImpl;
import com.guide_finder.dao.impl.language.LanguageDaoImpl;
import com.guide_finder.dao.impl.location.LocationDaoImpl;
import com.guide_finder.dao.impl.role.RoleDaoImpl;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.location.LocationService;
import com.guide_finder.service.impl.LanguageServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationDao locationDao;


    public LocationServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        this.locationDao = new LocationDaoImpl(connection);
    }

    @Override
    public List<Country> getAllCountries() {
        return locationDao.getAllCountries();
    }

    @Override
    public List<City> getCitiesByCountry(Country country) {
        return locationDao.getCitiesByCountry(country);
    }
    @Override
    public List<City> getCitiesByCountryId(Long id) {
        return locationDao.getCitiesByCountryId(id);
    }
}

