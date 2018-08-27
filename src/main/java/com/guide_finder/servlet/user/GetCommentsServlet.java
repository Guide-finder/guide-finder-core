package com.guide_finder.servlet.user;

import com.google.gson.Gson;
import com.guide_finder.model.comment.Commentary;
import com.guide_finder.service.abstraction.commentaries.CommentaryService;
import com.guide_finder.service.impl.CommentaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/comments")
public class GetCommentsServlet extends HttpServlet {

    private final CommentaryService commentaryService = new CommentaryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long recipientId = Long.parseLong(req.getParameter("recipientId"));

        List<Commentary> commentaryList = commentaryService.getAllCommentariesByRecipientId(recipientId);

        String gSon = new Gson().toJson(commentaryList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(gSon);

    }
}
