package com.guide_finder.servlet;

import com.guide_finder.dao.abstraction.UserDao;
import com.guide_finder.dao.impl.UserDaoImpl;
import com.guide_finder.util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/admin/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao service;
        try {
            service = new UserDaoImpl();
            long id = Long.parseLong(req.getParameter("id"));
            service.deleteUser(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin");

    }
}