package com.guide_finder.dao.impl;

import com.guide_finder.model.comment.Commentary;
import com.guide_finder.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentariesDaoImpl extends AbstractDao {
    private Connection connection;

    public CommentariesDaoImpl(DBHelper dbHelper) throws ClassNotFoundException,
            SQLException, InstantiationException, IllegalAccessException {
        this.connection = DBHelper.getConnection();
    }

    public Commentary getCommentaryById(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM commentary WHERE id='" + id + "'");
        ResultSet result = stmt.getResultSet();
            return new Commentary(
                    result.getLong(2),
                    result.getLong(3),
                    result.getString(4),
                    result.getBoolean(5)
                    );
        }

    public Commentary getCommentaryByAuthorId(long authorId) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM commentary WHERE author_id='" + authorId + "'");
        ResultSet result = stmt.getResultSet();
        return new Commentary(
                result.getLong(2),
                result.getLong(3),
                result.getString(4),
                result.getBoolean(5)
        );
    }

    public Commentary getCommentaryByRecipientIdId(long recipientId) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM commentary WHERE recipient_id='" + recipientId + "'");
        ResultSet result = stmt.getResultSet();
        return new Commentary(
                result.getLong(2),
                result.getLong(3),
                result.getString(4),
                result.getBoolean(5)
        );
    }


    public void saveCommentary(Commentary commentary) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO commentary (author_id, recipient_id, rate, message) VALUES ('"
                + commentary.getAuthorId() + "', '"
                + commentary.getRecipientId() + "', '"
                + commentary.isRate() + "', '"
                + commentary.getMessage() + "')");
    }


    public void editCommentary(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(
                "UPDATE commentary SET rate='" + getCommentaryById(id).isRate()
                        + "', message='" + getCommentaryById(id).getMessage()
                        + "' WHERE id='" + id + "'");
    }


    public void delete(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM comments WHERE id='" + id + "'");
    }

    public List<Commentary> getAllCommentaries() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM users;");
        ResultSet result = stmt.getResultSet();
        List<Commentary> comList = new ArrayList<>();
        comList.add(new Commentary(result.getLong(2),
                                    result.getLong(3),
                                    result.getString(4),
                                    result.getBoolean(5)));
        return comList;
    }
}
