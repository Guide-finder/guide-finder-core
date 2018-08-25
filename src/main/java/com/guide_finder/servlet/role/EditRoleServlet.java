package com.guide_finder.servlet.role;

import com.guide_finder.model.user.Role;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/editRole")
public class EditRoleServlet extends HttpServlet {
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer idRoleToEdit = Integer.parseInt(req.getParameter("id"));
        Role role = roleService.getRoleById(idRoleToEdit);
        req.setAttribute("role",role);
        req.getRequestDispatcher("/editRole.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("roleId"));
        String newName = req.getParameter("name");
        roleService.editRole(id, newName);
        resp.sendRedirect("/admin/roles");

    }
}
