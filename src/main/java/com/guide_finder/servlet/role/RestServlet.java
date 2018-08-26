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

@WebServlet("/rest")
public class RestServlet extends HttpServlet {

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String newRoleName = req.getParameter("newRole");
        if(newRoleName != null || !"".equals(newRoleName.trim())){
            roleService.saveRole(newRoleName);

        Role role = roleService.getRoleByName(newRoleName);

        String s = new Gson().toJson(role);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(s);
    }


    }

}

