package com.guide_finder.servlet;


import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Author Didenko B.
 */

@WebServlet("/admin/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();

            long id = Long.parseLong(req.getParameter("id"));
            service.deleteUser(id);

        resp.sendRedirect("/admin");

    }
}