package com.guide_finder.servlet.location;


import com.google.gson.Gson;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.location.LocationService;
import com.guide_finder.service.impl.location.LocationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/location")
public class LocationServlet extends HttpServlet{
    private final LocationService locationService = new LocationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("country") != null) {
            List<City> cities = locationService.getCitiesByCountryId(Long.parseLong(req.getParameter("country")));
            resp.getWriter().write(new Gson().toJson(cities));
            return;
        }
        List<Country> countries = locationService.getAllCountries();
        resp.getWriter().write(new Gson().toJson(countries));


    }
}
