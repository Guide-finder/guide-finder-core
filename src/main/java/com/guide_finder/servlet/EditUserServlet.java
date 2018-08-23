package com.guide_finder.servlet;

import com.guide_finder.dao.abstraction.UserDao;
import com.guide_finder.dao.impl.UserDaoImpl;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            UserDaoImpl dao = new UserDaoImpl();
            user = dao.getUserById(Long.valueOf(req.getParameter("userId")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> sexList = new ArrayList<>();
        for (Sex s : Sex.values()) {
            sexList.add(s.name());
        }
        String sex = user.getSex().name();
        req.setAttribute("user", user);
        req.setAttribute("sexSelected", sex);
        req.setAttribute("sexList", sexList);
        req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long userId = Long.valueOf(req.getParameter("userId"));

        try {
            UserDaoImpl dao = new UserDaoImpl();
            dao.editUser(
                    userId,
                    req.getParameter("password"),
                    req.getParameter("email"),
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("phone"),
                    Integer.valueOf(req.getParameter("age")),
                    req.getParameter("sex")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        //req.getRequestDispatcher(String.format("/editUser?userId=%s", userId)).forward(req, resp);


        resp.sendRedirect("/editUser?userId="+userId);


    }
}
