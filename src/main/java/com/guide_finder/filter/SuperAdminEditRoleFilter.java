package com.guide_finder.filter;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/roles")
public class SuperAdminEditRoleFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = ((HttpServletRequest)request).getSession();
        User user = (User) session.getAttribute("user");
        RoleService roleService = new RoleServiceImpl();
        Role roleSuperAdmin = roleService.getRoleById(3);

        if (roleSuperAdmin != null || user.getRoles().contains(roleSuperAdmin)) {
            filterChain.doFilter(request, response);
            return;
        } else {
            ((HttpServletResponse) response).sendRedirect("/error");
        }

    }

    @Override
    public void destroy() {

    }


}