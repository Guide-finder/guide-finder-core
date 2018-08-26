package com.guide_finder.dao.impl.location;

import com.guide_finder.dao.abstraction.location.LocationDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;
import com.guide_finder.model.user.Language;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LocationDaoImpl implements LocationDao {
    private final Executor executor;

    public LocationDaoImpl(Connection connection) {
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

    @Override
    public List<City> getAllCities() {
        return executor.execQuery("SELECT * FROM city;",
                result -> {
                    List<City> listCouries = new ArrayList<>();
                    while (result.next()) {
                        listCouries.add(
                                new City(result.getLong(1),
                                        result.getString(3))
                        );
                    }
                    return listCouries;
                });
    }

    @Override
    public List<City> getCitiesByCountry(Country country) {
        return executor.execQuery("SELECT id, name FROM  city where region_id in (SELECT id FROM region where country_id = "+country.getId()+")",
                result -> {
                    List<City> listCouries = new ArrayList<>();
                    while (result.next()) {
                        listCouries.add(
                                new City(result.getLong(1),
                                        result.getString(2))
                        );
                    }
                    return listCouries;
                });
    }

    @Override
    public List<City> getCitiesByCountryId(Long id) {
        return executor.execQuery("SELECT id, name FROM  city where region_id in (SELECT id FROM region where country_id = "+id+")",
                result -> {
                    List<City> listCouries = new ArrayList<>();
                    while (result.next()) {
                        listCouries.add(
                                new City(result.getLong(1),
                                        result.getString(2))
                        );
                    }
                    return listCouries;
                });
    }

    public int getCoordsCount(){
        return executor.execQuery("select count(*) from coord", result -> {
            result.next();
            return result.getInt(1);
        });
    }
}
