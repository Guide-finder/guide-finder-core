package com.guide_finder.servlet;

import com.guide_finder.model.user.User;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userFilter")
public class UserFilterServlet extends HttpServlet {

    private UserServiceImpl usi = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> userList= usi.getAllUsers();

        req.setAttribute("users", userList);

        resp.setContentType("text/html");
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> userList = usi.getAllUsers(req.getParameter("city"));

        req.setAttribute("users", userList);

        resp.setContentType("text/html");
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);

    }

}
