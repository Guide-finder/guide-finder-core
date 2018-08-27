package com.guide_finder.servlet.role;


import com.google.gson.Gson;
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



/**
 * Created by Dikobob on 27.08.18.
 */
@WebServlet("/saveRoles")
public class SaveRoleServlet extends HttpServlet {
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Role> roles = roleService.getAllRoles();

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(new Gson().toJson(roles));
            resp.getWriter().write(new Gson().toJson(roles));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}