package com.guide_finder.dao.impl;

import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.contact.SocialContact;

import java.sql.Connection;
import java.sql.SQLException;

public class SocialContactDaoImpl extends AbstractDao {
    private Executor executor;

    public SocialContactDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    public SocialContact getSocialContact(long id) throws SQLException {
        return executor.execQuery("SELECT * FROM socialcontact WHERE user_id =" + id, result -> {
            result.next();
            return new SocialContact(result.getString(2),
                                        result.getString(3),
                                        result.getString(4),
                                        result.getString(5));
        });
    }

    public String getSocialContactSingle(long id, String col) throws SQLException {
        return executor.execQuery("SELECT " + col + " FROM socialcontact WHERE user_id =" + id, result -> {
            result.next();
            return result.getString(2);
        });
    }

    public void updateSocialContactSingle(long id, String col, String newValue) throws SQLException {
        executor.execUpdate("UPDATE socialcontact SET " + col + " = \"" + newValue + "\" WHERE user_id = " + id);
    }
}