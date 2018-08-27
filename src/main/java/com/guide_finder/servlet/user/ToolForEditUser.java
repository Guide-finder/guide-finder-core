package com.guide_finder.servlet.user;

import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/toolsEditUser")
public class ToolForEditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        String user_id = req.getParameter("id");
        String city = req.getParameter("currentCity");
        List<String> language;
        List<String> category;
        List<String> role;
        if (req.getParameterValues("currentLanguage[]") != null) {
            language = new ArrayList<>(Arrays.asList((String[]) req.getParameterValues("currentLanguage[]")));
        }
        else {
            language = null;
        }
        if (req.getParameterValues("currentCategory[]") != null) {
            category = new ArrayList<>(Arrays.asList((String[]) req.getParameterValues("currentCategory[]")));
        }
        else {
            category = null;
        }
        if (req.getParameterValues("currentRole[]") != null) {
            role = new ArrayList<>(Arrays.asList((String[]) req.getParameterValues("currentRole[]")));
        }
        else {
            role = new ArrayList<String>();
            role.add("2");
        }
        service.editCustomUserOptions(Long.parseLong(user_id), city, language, category, role);
    }
}
