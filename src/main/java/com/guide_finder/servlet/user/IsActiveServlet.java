package com.guide_finder.servlet.user;

import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setUserActive")
public class IsActiveServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        boolean isActive = Boolean.valueOf(req.getParameter("isActive"));
        long userId = Long.valueOf(req.getParameter("userId"));


        if (isActive) {
            Double latitude = Double.valueOf(req.getParameter("latitude"));
            Double longitude = Double.valueOf(req.getParameter("longitude"));
            if (latitude != null && longitude != null) {
                userService.setCoord(userId, latitude, longitude);
            }
            userService.setUserActive(1, userId);
        } else {
            userService.setUserActive(0, userId);
            userService.deleteUserCoord(userId);
        }

        //req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
