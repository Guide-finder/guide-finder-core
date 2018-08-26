package com.guide_finder.dao.impl.location;

import com.guide_finder.dao.abstraction.location.CityDao;
import com.guide_finder.dao.abstraction.location.CountryDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class CityDaoImpl implements CityDao {

    private final Executor executor;

    public CityDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }


    @Override
    public List<City> getAllCitiesByCountry(long country_id) {
        return executor.execQuery("SELECT id, name FROM  city where region_id in (SELECT id FROM region where country_id = " + country_id + ")",
                result -> {
                    List<City> listCities = new ArrayList<>();
                    while (result.next()) {
                        listCities.add(
                                new City(result.getLong(1),
                                        result.getString(2))
                        );
                    }
                    return listCities;
                });
    }
}