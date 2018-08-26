package com.guide_finder.servlet.role;
import com.guide_finder.model.user.Role;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//
//
@WebServlet("/admin/deleteRole")
public class DeleteRoleServlet extends HttpServlet {

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        int idRoleToDel = Integer.parseInt(req.getParameter("id"));
        if (roleService.getRoleById(idRoleToDel) != null) {
            roleService.deleteRole(idRoleToDel);
        }


        resp.sendRedirect("/admin/roles");




    }

    }

