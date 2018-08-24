package com.guide_finder.servlet.role;

import com.guide_finder.model.user.Role;
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

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer idRoleToEdit = Integer.parseInt(req.getParameter("id"));

        RoleServiceImpl roleService = new RoleServiceImpl();
        Role role = roleService.getRoleById(idRoleToEdit);
        req.setAttribute("role",role);
        resp.getWriter().write("Edite Role Operation id = " + idRoleToEdit + " " + role.getName());

        req.setAttribute("rolename", role.getName());
        req.setAttribute("id", idRoleToEdit);
        req.getRequestDispatcher("/editRole.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("roleId"));
        String newName = req.getParameter("name");
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleService.editRole(id, newName);
        resp.sendRedirect("/admin/roles");


    }
}
