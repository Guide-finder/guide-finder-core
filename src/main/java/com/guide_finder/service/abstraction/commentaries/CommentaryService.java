package com.guide_finder.service.abstraction.commentaries;

import com.guide_finder.model.comment.Commentary;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface CommentaryService {
//    public Commentary getCommentaryById(long id) throws SQLException;
//    public Commentary getCommentaryByAuthorId(long authorId) throws SQLException;
//    public Commentary getCommentaryByRecipientIdId(long recipientId) throws SQLException;
    public void saveCommentary(Commentary commentary);
////    public void editCommentary(long id) throws SQLException;
////    public void deleteCommentary(long id) throws SQLException;
    public List<Commentary> getAllCommentariesByRecipientId(long id);
    public List<String> getNamesOfAllCommentAuthorsByRecipientId (long id) throws ClassNotFoundException,
                                                                                    SQLException,
                                                                                    InstantiationException,
                                                                                    IllegalAccessException;


}
