package com.guide_finder.servlet.admin;

import com.google.gson.Gson;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author Didenko B.
 */

@WebServlet("/admin/partUser")
public class AdminPagePartServlet extends HttpServlet {
    private final UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;

        long lastId = Long.parseLong(req.getParameter("lastId"));
        String role = req.getParameter("role");


        if ("admin".equals(role)) {
            users = service.getPartOfUsers(lastId, 1);
            req.setAttribute("userRole", "admin");
        }
        else if ("user".equals(req.getParameter("role"))) {
            users = service.getPartOfUsers(lastId, 2);
            req.setAttribute("userRole", "user");
        }
        else {
            users= service.getPartOfUsers(lastId);
            req.setAttribute("userRole", "all");
        }

//        req.setAttribute("users", users);

//        resp.setContentType("text/html");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminPage.jsp");
//        dispatcher.forward(req, resp);

        String json = new Gson().toJson(users);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ("admin".equals(req.getParameter("role"))) {
            long newUser = service.saveUser(new User(req.getParameter("firstname"),
                                                    req.getParameter("lastname"),
                                                    req.getParameter("email"),
                                                    req.getParameter("password"),
                                                    req.getParameter("phone"),-1, Sex.MAN));
            boolean dontGotIt = service.setRoleToUser(newUser, 1);
        }

        else {
            long newUser = service.saveUser(new User(req.getParameter("firstname"),
                                                    req.getParameter("lastname"),
                                                    req.getParameter("email"),
                                                    req.getParameter("password"),
                                                    req.getParameter("phone"),-1, Sex.MAN));

        }

        //resp.getWriter().println("User " + req.getParameter("firstname") + " " + req.getParameter("lastname") + " is added!");
        resp.sendRedirect("/admin");
    }
}
