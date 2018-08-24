package com.guide_finder.servlet.auth;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isInvalid", false);
        req.setAttribute("isRegister", false);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    //добавить метод dopost, котторый принимает логин и прааольь, делаетт сравение по базе и в зависимости от роли делает
    //редирект на нужную страницу (либо юзер, либо админ)

    @Override
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res) throws ServletException, IOException{
        try {
            Role roleAdmin = roleService.getRoleById(1);
            Role roleUser = roleService.getRoleById(2);

            if (roleAdmin == null) {
                try {
                    throw (new Exception("Role 'Admin' is not found"));
                } catch (Exception e) {
                    //todo logging
                    e.printStackTrace();
                }
            }
            if (roleUser == null) {
                try {
                    throw (new Exception("Role 'User' is not found"));
                } catch (Exception e) {
                    //todo logging
                    e.printStackTrace();
                }
            }

            User user = userService.getUserByEmail(req.getParameter("login"));

            if (user != null && req.getParameter("password").equals(user.getPassword())) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("firstName", user.getFirstName());
                if (user.getRoles().contains(roleAdmin)) {
                    req.getRequestDispatcher("adminPage.html").forward(req, res);
                } else if (user.getRoles().contains(roleUser)) {
                    req.getRequestDispatcher("user.jsp").forward(req, res);
                } else {
                    req.setAttribute("isInvalidRole", true);
                    req.getRequestDispatcher("login.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("isInvalid", true);
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }

        } catch  (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}