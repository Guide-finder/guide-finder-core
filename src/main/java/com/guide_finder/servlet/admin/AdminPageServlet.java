package com.guide_finder.servlet.admin;

import com.guide_finder.dao.abstraction.UserDao;
import com.guide_finder.dao.impl.UserDaoImpl;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class AdminPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = null;
        UserDao service;

        if ("admin".equals(req.getParameter("role"))) {
            try {
                service = new UserDaoImpl();
                users = service.getUsersByRole(2, service);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else if ("user".equals(req.getParameter("role"))) {
            try {
                service = new UserDaoImpl();
                users= service.getUsersByRole(1,service);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else {
                try {
                    service = new UserDaoImpl();
                    users= service.getAllUsers();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            req.setAttribute("users", users);

            resp.setContentType("text/html");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/adminPage.jsp");
            dispatcher.forward(req, resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao service;
        try {
            service = new UserDaoImpl();
            service.saveUser(req.getParameter("password"),
                            req.getParameter("email"),
                            req.getParameter("firstname"),
                            req.getParameter("lastname"),
                            req.getParameter("phone"),-1, "MALE");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //resp.getWriter().println("User " + req.getParameter("firstname") + " " + req.getParameter("lastname") + " is added!");
        resp.sendRedirect("/admin");
    }
}
