package com.guide_finder.servlet.role;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//
//
@WebServlet("/admin/deleteRole")
public class DeleteRoleServlet extends HttpServlet {

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        Integer idRoleToDel = Integer.parseInt(req.getParameter("id"));
      //resp.getWriter().write("Delete Role Operation id = " + idRoleToDel);
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleService.deleteRole(idRoleToDel);
        resp.sendRedirect("/admin/roles");




    }

    }

