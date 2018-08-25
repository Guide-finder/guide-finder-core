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
@WebFilter ("/user")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("user filter");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        final RoleService roleService = new RoleServiceImpl();
        Role roleUser = roleService.getRoleById(2);
        Role roleBannedUser = roleService.getRoleById(3);
        String loginURI = request.getContextPath() + "/login";
        String loginUser = request.getContextPath() + "/user";

        if (user.getRoles().contains(roleUser)) {
            if(user.getRoles().contains(roleBannedUser)){
                response.sendRedirect(loginURI);
            } else {
                response.sendRedirect(loginUser);
                chain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
