package com.guide_finder.dao.impl.commentary;

import com.guide_finder.dao.impl.AbstractDao;
import com.guide_finder.model.comment.Commentary;
import com.guide_finder.model.user.User;
import com.guide_finder.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentariesDaoImpl extends AbstractDao {
    private Connection connection;

    public CommentariesDaoImpl() throws ClassNotFoundException,
            SQLException, InstantiationException, IllegalAccessException {
        this.connection = DBHelper.getConnection();
    }

    public Commentary getCommentaryById(long id) throws SQLException {
        Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM commentary WHERE id='" + id + "'");
            ResultSet result = stmt.getResultSet();
            result.next();
            stmt.close();
            result.close();
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
        result.next();
        stmt.close();
        result.close();
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
        result.next();
        stmt.close();
        result.close();
        return new Commentary(
                result.getLong(2),
                result.getLong(3),
                result.getString(4),
                result.getBoolean(5)
        );
    }


    public void saveCommentary(Commentary commentary) throws SQLException {
        byte i;
        if(commentary.isRate()){
            i=1;
        }else{
            i=0;
        }
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO commentary (author_id, recipient_id, rate, message) VALUES ('"
                + commentary.getAuthorId() + "', '"
                + commentary.getRecipientId() + "', '"
                + i + "', '"
                + commentary.getMessage() + "')");
        stmt.close();
    }


    public void editCommentary(long id) throws SQLException {
        int i;
        if(getCommentaryById(id).isRate()){
            i = 1;
        } else {
            i = 0;
        }
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(
                "UPDATE commentary SET rate='" + i
                        + "', message='" + getCommentaryById(id).getMessage()
                        + "' WHERE id='" + id + "'");
        stmt.close();
    }


    public void delete(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM commentary WHERE id='" + id + "'");
    }

    public List<Commentary> getAllCommentaries() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM commentary;");
        ResultSet result = stmt.getResultSet();
        result.next();
        List<Commentary> comList = new ArrayList<>();
        comList.add(new Commentary(result.getLong(2),
                                    result.getLong(3),
                                    result.getString(4),
                                    result.getBoolean(5)));
        stmt.close();
        result.close();
        return comList;
    }

    public List<Commentary> getAllCommentariesByRecipientId(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = String.format("select * from commentary where recipient_id='%s'", id);
        stmt.execute(sql);

        ResultSet result = stmt.getResultSet();
        List<Commentary> comList = new ArrayList<>();

        while (result.next()){
            comList.add(new Commentary(result.getLong(2),
                    result.getLong(3),
                    result.getString(4),
                    result.getBoolean(5)));
        }
        stmt.close();
        result.close();
        return comList;
    }

    public List<String> getNamesOfAllCommentAuthorsByRecipientId (long id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<String> namesOfAuthors = new ArrayList<>();
        Connection connection = DBHelper.getConnection();
        Statement stm = connection.createStatement();
        String sql = String.format("select u.firstname from user u where id IN (select author_id from commentary where recipient_id='%s'",id);
        stm.executeQuery(sql);

        ResultSet resultSet = stm.getResultSet();

        while (resultSet.next()){
            namesOfAuthors.add(resultSet.getString(1));
        }
        return namesOfAuthors;
    }

}
