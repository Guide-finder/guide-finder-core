package com.guide_finder.service.impl;

import com.guide_finder.dao.impl.commentary.CommentariesDaoImpl;
import com.guide_finder.model.comment.Commentary;
import com.guide_finder.service.abstraction.commentaries.CommentaryService;
import com.guide_finder.util.DBHelper;

import java.awt.image.DataBuffer;
import java.sql.SQLException;
import java.util.List;

public class CommentaryServiceImpl implements CommentaryService {
    private CommentariesDaoImpl commentariesDao;

    public CommentaryServiceImpl() {
        try {
            this.commentariesDao = new CommentariesDaoImpl(DBHelper.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Commentary getCommentaryById(long id) throws SQLException {
//        return commentariesDao.getCommentaryById(id);
//    }
//
//    @Override
//    public Commentary getCommentaryByAuthorId(long authorId) throws SQLException {
//        return commentariesDao.getCommentaryById(authorId);
//    }
//
//    @Override
//    public Commentary getCommentaryByRecipientIdId(long recipientId) throws SQLException {
//        return commentariesDao.getCommentaryByRecipientIdId(recipientId);
//    }
//
    @Override
    public void saveCommentary(Commentary commentary) {
        commentariesDao.saveCommentary(commentary);
    }
//
//    @Override
//    public void editCommentary(long id) throws SQLException {
//        commentariesDao.editCommentary(id);
//    }

//    @Override
//    public void deleteCommentary(long id) throws SQLException {
//
//    }

    @Override
    public List<Commentary> getAllCommentariesByRecipientId(long id) {
        return commentariesDao.getAllCommentariesByRecipientId(id);
    }

    @Override
    public List<String> getNamesOfAllCommentAuthorsByRecipientId(long id) throws ClassNotFoundException,
            SQLException,
            InstantiationException,
            IllegalAccessException {
        return commentariesDao.getNamesOfAllCommentAuthorsByRecipientId(id);
    }
}
