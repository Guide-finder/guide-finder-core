package com.guide_finder.servlet.location;

import com.google.gson.Gson;
import com.guide_finder.model.location.City;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.location.CityService;
import com.guide_finder.service.abstraction.location.CountryService;
import com.guide_finder.service.impl.location.CityServiceImpl;
import com.guide_finder.service.impl.location.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cities")
public class CityGetServlet extends HttpServlet {
    private final CityService cityService = new CityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<City> cities = cityService.getAllCitiesByCounttry(Long.parseLong(request.getParameter("country_id")));

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(cities));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}