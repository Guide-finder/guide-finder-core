package com.guide_finder.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter ("/*")
public class AuthorizationFilter implements Filter {
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
        String loginURI = request.getContextPath() + "/login";
        String loginRegister = request.getContextPath() + "/register";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean regRequest = request.getRequestURI().equals(loginRegister);

        //if ()

        if (loggedIn) {
            chain.doFilter(request, response);
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else if (regRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/login");
        }


    }

    @Override
    public void destroy() {

    }
}
