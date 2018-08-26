package com.guide_finder.servlet.search;

import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stepanegorov on 26.08.18.
 */
@WebServlet("/guideSearch")
public class GuideSearchServlet extends HttpServlet{

    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = service.getAllUsers();
        req.setAttribute("users", users);

        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user;
        long cityId = Long.parseLong(req.getParameter("currentCity"));
        String categoryName = req.getParameter("currentCategory");

        List<String> languageList = new ArrayList<>();


        if (req.getParameterValues("currentLanguage[]") != null) {
            languageList = new ArrayList<>(Arrays.asList((String[]) req.getParameterValues("currentLanguage[]")));
            user = service.usersBySearch(cityId, languageList, categoryName);
        }

        else {
                languageList = new ArrayList<>(Arrays.asList((String[]) req.getParameterValues("currentLanguage[]")));
                user = service.usersBySearch(cityId, null, categoryName);
        }
        resp.sendRedirect("/guideSearch");
    }
}
