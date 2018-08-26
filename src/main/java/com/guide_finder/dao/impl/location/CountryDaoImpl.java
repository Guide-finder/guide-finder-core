package com.guide_finder.dao.impl.location;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.dao.abstraction.location.CountryDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.category.Category;
import com.guide_finder.model.location.Country;
import com.guide_finder.model.user.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CountryDaoImpl implements CountryDao {

    private final Executor executor;

    public CountryDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }


    @Override
    public List<Country> getAllCountries() {
        return executor.execQuery("SELECT * FROM country;",
                result -> {
                    List<Country> listCouries = new ArrayList<>();
                    while (result.next()) {
                        listCouries.add(
                                new Country(result.getLong(1),
                                        result.getString(2))
                        );
                    }
                    return listCouries;
                });
    }
}