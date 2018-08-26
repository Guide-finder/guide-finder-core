/*
package com.guide_finder.servlet.user;

import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/viewUser")
public class SetCoordServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long userId = Long.valueOf(req.getParameter("userId"));
        double latitude= Double.valueOf(req.getParameter("latitude"));
        double longitude= Double.valueOf(req.getParameter("longitude"));
        userService.setCoord(userId, latitude, longitude);

        req.setAttribute("latitude", list.get(0));
        req.setAttribute("longitude", list.get(1));

        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
*/
