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
@WebFilter ("/you")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("admin filter");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        RoleService roleService = new RoleServiceImpl();
        Role roleAdmin = roleService.getRoleById(1);
        String loginAdmin = request.getContextPath() + "/admin";

        if(user == null) {
            response.sendRedirect("/login.jsp");
        }else if (user.getRoles().contains(roleAdmin)){
            response.sendRedirect(loginAdmin);
        }else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
