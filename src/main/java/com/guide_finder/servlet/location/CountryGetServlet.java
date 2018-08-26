package com.guide_finder.servlet.location;

import com.google.gson.Gson;
import com.guide_finder.model.location.Country;
import com.guide_finder.service.abstraction.category.CategoryService;
import com.guide_finder.service.abstraction.location.CountryService;
import com.guide_finder.service.impl.category.CategoryServiceImpl;
import com.guide_finder.service.impl.location.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/countries")
public class CountryGetServlet extends HttpServlet {
    private final CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<Country> countries = countryService.getAllCountries();

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(countries));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}