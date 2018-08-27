package com.guide_finder.servlet.language;

import com.google.gson.Gson;
import com.guide_finder.model.user.Language;
import com.guide_finder.service.abstraction.language.LanguageService;
import com.guide_finder.service.impl.LanguageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by stepanegorov on 27.08.18.
 */
@WebServlet("/language")
public class LanguageServlet extends HttpServlet {
    private LanguageService languageService = new LanguageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Language> languages = languageService.getAllLanguages();

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(new Gson().toJson(languages));
            resp.getWriter().write(new Gson().toJson(languages));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
