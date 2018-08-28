package com.guide_finder.servlet;
import com.google.gson.Gson;
import com.guide_finder.dao.impl.role.GuideDaoImpl;
import com.guide_finder.model.comment.Commentary;
import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.user.*;
import com.guide_finder.service.abstraction.commentaries.CommentaryService;
import com.guide_finder.service.abstraction.guide.GuideService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.CommentaryServiceImpl;
import com.guide_finder.service.impl.GuideServiceImpl;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/user/profile")
public class GuideProfileServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final GuideService guideService = new GuideServiceImpl();
    private final CommentaryService commentaryService = new CommentaryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));

        User user = userService.getUserById(id);
        Guide guide = guideService.getGuideById(id);
        List<Commentary> commentaryList = commentaryService.getAllCommentariesByRecipientId(id);
        SocialContact socialContacts = userService.getSocialContactsById(id);

        req.setAttribute("userFirstName", user.getFirstName());
        req.setAttribute("userLastName", user.getLastName());
        req.setAttribute("description", guide.getDescription());
        req.setAttribute("comments", commentaryList);
        req.setAttribute("socialcontacts", socialContacts);
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("mail", user.getEmail());
        req.setAttribute("id", user.getId());

        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long senderId = Long.valueOf(req.getParameter("senderId"));
        long recipientId = Long.valueOf(req.getParameter("recipientId"));
        String comment = req.getParameter("comment");


        String authorName = userService.getUserById(senderId).getFirstName();   //todo refactor

        Commentary newCommentary = new Commentary(senderId, recipientId, comment);
        commentaryService.saveCommentary(newCommentary);

        newCommentary = new Commentary(authorName,comment);     //todo refactor

        String comments = new Gson().toJson(newCommentary);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(comments);
    }
}
