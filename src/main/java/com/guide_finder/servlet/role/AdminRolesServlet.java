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
@WebServlet("/admin/roles")
public class AdminRolesServlet extends HttpServlet {

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

            List<Role> roles = roleService.getAllRoles();
            resp.setCharacterEncoding("UTF-8");
            req.setAttribute("roles", roles);
            req.getRequestDispatcher("/adminRoles.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newRolename = request.getParameter("newRole");
        roleService.saveRole(newRolename);
        response.sendRedirect("/admin/roles");
    }
    }

