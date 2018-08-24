package com.guide_finder.servlet.user;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) {

        try {
            UserService userService = new UserServiceImpl();

            RoleService roleService = new RoleServiceImpl();
            Role roleUser = roleService.getRoleById(2);

            if (roleUser == null) {
                try {
                    throw (new Exception("Role 'USER' is not found"));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Set<Role> roles = new HashSet<Role>();
            roles.add(roleUser);

            User user = new User(0,
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("email"),
                    req.getParameter("password"),
                    req.getParameter("phone"),
                    Integer.parseInt(req.getParameter("age")),
                    Sex.valueOf(req.getParameter("sex")));
            userService.saveUser(user);

            System.out.println(user.getFirstName());

            req.setAttribute("firstName", user.getFirstName());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
            dispatcher.forward(req, resp);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}