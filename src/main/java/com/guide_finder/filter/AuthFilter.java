package com.guide_finder.filter;

import javax.servlet.*;
import javax.servlet.Filter;
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
        String loginURI = request.getContextPath() + "/login";
        String loginRegister = request.getContextPath() + "/register";
        String loginAdmin = request.getContextPath() + "/admin";
        String loginUser = request.getContextPath() + "/user";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean regRequest = request.getRequestURI().equals(loginRegister);
        boolean adminRequest = request.getRequestURI().equals(loginAdmin);
        boolean userRequest = request.getRequestURI().equals(loginUser);

        //if ()

        if (loggedIn) {
            chain.doFilter(request, response);
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else if (regRequest) {
            chain.doFilter(request, response);
        } else if (adminRequest){
            chain.doFilter(request, response);
        } else if (userRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }


    }

    @Override
    public void destroy() {

    }
}
