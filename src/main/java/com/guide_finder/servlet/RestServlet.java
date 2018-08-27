package com.guide_finder.servlet;

import com.google.gson.Gson;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rest")
public class RestServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        int state = service.getUserStateById(user.getId());

        String s = new Gson().toJson(state);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int status = Integer.parseInt(req.getParameter("state"));
        final HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        service.setUserActive(status, user.getId());

    }

}
