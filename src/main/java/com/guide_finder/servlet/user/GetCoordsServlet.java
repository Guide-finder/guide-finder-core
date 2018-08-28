package com.guide_finder.servlet.user;

import com.google.gson.Gson;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet("/getCoords")
public class GetCoordsServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long guide = Long.valueOf(req.getParameter("guide"));
        long me = Long.valueOf(req.getParameter("me"));
        List<List<Double>> sumList = new ArrayList<>();
        if (userService.getCoord(me) != null) {
            List<Double> myCoord = userService.getCoord(me);
            sumList.add(myCoord);
        }
        if (userService.getCoord(guide) != null) {
            List<Double> guideCoord = userService.getCoord(guide);
            sumList.add(guideCoord);
        }
        String sumCoordJSON = new Gson().toJson(sumList);
        resp.getWriter().write(sumCoordJSON);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

    }
}

