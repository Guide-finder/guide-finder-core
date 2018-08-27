package com.guide_finder.servlet.chat;

import com.guide_finder.model.comment.Commentary;
import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.user.Guide;
import com.guide_finder.model.user.User;

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
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("user_id", req.getParameter("user_id"));

//        long id = Long.parseLong(req.getParameter("id"));
//
//        User user = userService.getUserById(id);
//        Guide guide = guideService.getGuideById(id);
//        List<Commentary> commentaryList = commentaryService.getAllCommentariesByRecipientId(id);
//        SocialContact socialContacts = userService.getSocialContactsById(id);
//
//        req.setAttribute("userId", user.getId());

//        req.getParameter("user_id");
//        req.setAttribute("isInvalid", false);
//        req.setAttribute("isRegister", false);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/Chat.jsp");
        dispatcher.forward(req, resp);
    }
}