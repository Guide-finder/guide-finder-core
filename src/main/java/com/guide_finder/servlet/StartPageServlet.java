package com.guide_finder.servlet;

import javafx.util.Pair;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/start")
public class StartPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("country");

        System.out.println("id country = " + id);
        UserServiceImpl usServ = null;

        try {
            usServ = UserServiceImpl.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("showCat", id == null);
        if (id == null) {
            List<Pair> listCountries = null;
//            try {
//                UserServiceImpl usServ = UserServiceImpl.getInstance();
                listCountries = usServ.getAllCountriees();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            request.setAttribute("countries", listCountries);
        } else {
            System.out.println("country id = " + Integer.parseInt(id));
            String countryName = usServ.getCountryById(Integer.parseInt(id));
            System.out.println("country name = " + countryName);
            request.setAttribute("description", countryName);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/StartPage.jsp");
        dispatcher.forward(request, response);
    }
}