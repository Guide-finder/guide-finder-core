package com.guide_finder.filter;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
    @WebFilter ("/*")
    public class AuthFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("auth filter");
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
                throws ServletException, IOException {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            HttpSession session = request.getSession();
            String loginUri = request.getContextPath() + "/login";
            String regUri = request.getContextPath() + "/registration";
            String adminUri = request.getContextPath() + "/admin";
            String userUri = request.getContextPath() + "/user";
            User user = (User) session.getAttribute("user");
            RoleService roleService = new RoleServiceImpl();
            Role roleAdmin = roleService.getRoleById(1);
            Role roleUser = roleService.getRoleById(2);

            boolean loggedIn = session.getAttribute("user") != null;
            boolean loginRequest = request.getRequestURI().equals(loginUri);
            boolean regRequest = request.getRequestURI().equals(regUri);
            boolean adminRequest = request.getRequestURI().equals(adminUri);
            boolean userRequest = request.getRequestURI().equals(userUri);

            if (loggedIn) {
                if (user.getRoles().contains(roleAdmin)) {
                    if(adminRequest || userRequest || regRequest || loginRequest) {
                        chain.doFilter(request, response);
                    }
                } else if (user.getRoles().contains(roleUser)) {
                    if (adminRequest) {
                        response.sendRedirect("/user");
                }
                    if (userRequest || regRequest || loginRequest)
                        chain.doFilter(request, response);
                }
            } else if (regRequest || loginRequest) {
                    chain.doFilter(request, response);
            } else {
                    response.sendRedirect("/login");
            }

        }

        @Override
        public void destroy() {

        }
    }
