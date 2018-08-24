package com.guide_finder.servlet;
import com.guide_finder.dao.impl.CommentariesDaoImpl;
import com.guide_finder.dao.impl.UserDaoImpl;
import com.guide_finder.dao.impl.role.GuideDaoImpl;
import com.guide_finder.model.comment.Commentary;
import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.user.*;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));

        User user = null;
        Guide guide = null;
        List<Commentary> commentaryList = null;
        List<String> commentaryAuthorNames = null;
        SocialContact socialContacts = null;
        String phone = null;
        String mail = null;

        try {
            user = new UserDaoImpl().getUserById(id);
            guide = new GuideDaoImpl().getGuideById(id);
            commentaryList = new CommentariesDaoImpl().getAllCommentariesByRecipientId(id);
            socialContacts = new UserDaoImpl().getSocialContactsById(id);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        req.setAttribute("userFirstName", user.getFirstName());
        req.setAttribute("userLastName", user.getLastName());
        req.setAttribute("description", guide.getDescription());
        req.setAttribute("comments", commentaryList);
        req.setAttribute("socialcontacts", socialContacts);
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("mail", user.getEmail());

        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }
}
