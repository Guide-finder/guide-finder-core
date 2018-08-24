package com.guide_finder.servlet.role;

import com.google.gson.Gson;
import com.guide_finder.model.category.Category;
import com.guide_finder.model.user.Role;
import com.guide_finder.service.abstraction.category.CategoryService;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;
import com.guide_finder.service.impl.category.CategoryServiceImpl;

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

        try {
            List<Role> roles = roleService.getAllRoles();
          //  resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Roles:" + System.lineSeparator());
            for (Role role : roles) {
                resp.getWriter().write(role.getId() + "  " + role.getName() + System.lineSeparator());
            }
           // resp.getWriter().write(new Gson().toJson(roles));

            req.setAttribute("roles",roles);
            req.getRequestDispatcher("/adminRoles.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newRolename = request.getParameter("newRole");
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleService.saveRole(newRolename);
        response.sendRedirect("/admin/roles");
    }


    }

