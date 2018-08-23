package com.guide_finder.servlet.category;

import com.google.gson.Gson;
import com.guide_finder.dao.impl.category.CategoryDaoImpl;
import com.guide_finder.model.category.Category;
import com.guide_finder.service.abstraction.category.CategoryService;
import com.guide_finder.service.impl.category.CategoryServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//
//
@WebServlet("/user/category")
public class CategoriesServlet extends HttpServlet {

    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Category> categories = categoryService.getAllCategories();

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(new Gson().toJson(categories));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}