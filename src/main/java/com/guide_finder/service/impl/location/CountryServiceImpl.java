package com.guide_finder.service.impl.location;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.dao.abstraction.location.CountryDao;
import com.guide_finder.dao.impl.category.CategoryDaoImpl;
import com.guide_finder.dao.impl.location.CountryDaoImpl;
import com.guide_finder.model.category.Category;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.category.CategoryService;
import com.guide_finder.service.abstraction.location.CountryService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    public CountryServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.countryDao = new CountryDaoImpl(connection);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }
}
