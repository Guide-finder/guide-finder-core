package com.guide_finder.servlet.auth;

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
import java.util.HashSet;
import java.util.Set;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/registration.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {


        Role roleUser = roleService.getRoleById(2);

        if (roleUser == null) {
            try {
                throw (new Exception("Role 'USER' is not found"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser); //todo не сохраняются роли

        User user = new User(0,
                req.getParameter("firstname"),
                req.getParameter("lastname"),
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("phone"),
                Integer.parseInt(req.getParameter("age")),
                Sex.valueOf(req.getParameter("sex")));

        user.setRoles(roles);

        userService.saveUser(user);

        req.setAttribute("firstName", user.getFirstName());
        req.setAttribute("isRegister", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);

    }
}