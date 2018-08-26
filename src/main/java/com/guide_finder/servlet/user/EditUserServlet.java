package com.guide_finder.servlet.user;

import com.guide_finder.dao.impl.user.UserDaoImpl;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;
import com.guide_finder.util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long userId = Long.valueOf(req.getParameter("userId"));

        User user = userService.getUserById(userId);

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

        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Sex sex = Sex.valueOf(req.getParameter("sex"));

        User user = new User(userId, firstName, lastName, email, password,  phone, age, sex);

        userService.editUser(user);

        resp.sendRedirect("/admin");

    }
}
