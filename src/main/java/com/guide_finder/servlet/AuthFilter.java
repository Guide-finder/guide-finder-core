package com.guide_finder.servlet;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    private Connection connection;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) {
        try {
            UserService userService = new UserServiceImpl();

            RoleService roleService = new RoleServiceImpl();
            Role roleAdmin = roleService.getRoleById(1);

            if (roleAdmin == null) {
                try {
                    throw (new Exception("Role 'Admin' is not found"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            User user = userService.getUserByEmail(req.getParameter("login"));

            if (user != null && req.getParameter("password").equals(user.getPassword())) {
                req.setAttribute("firstName", user.getFirstName());
                if (user.getRoles().contains(roleAdmin)) {
                    req.getRequestDispatcher("adminPage.html").forward(req, res);
                    sessoinParams(req);
                } else {
                    req.getRequestDispatcher("user.jsp").forward(req, res);
                    sessoinParams(req);

                }
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }

        } catch  (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }

    private void sessoinParams(ServletRequest req) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        httpServletRequest.getSession().setAttribute("login", req.getParameter("login"));

    }
}