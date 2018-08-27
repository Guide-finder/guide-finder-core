package com.guide_finder.dao.impl.role;

import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.user.Guide;
import com.guide_finder.model.user.User;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GuideDaoImpl  {

//    private Connection connection;
    private final Executor executor;

    public GuideDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Guide getGuideById(long id) {

        Guide guide = executor.execQuery(String.format("select * from guide where user_id='%s'", id), result -> {
            result.next();
            Guide guide1 = new Guide();
            guide1.setDescription(result.getString(3));
            return guide1;
        });
//        Guide guid = new Guide();
//        guid.setDescription(description);
//        return guid;

//        Statement statement = connection.createStatement();
//        String guideData = String.format("select * from guide where user_id='%s'",id);
//        statement.executeQuery(guideData);
//        try{
//            ResultSet resultSet = statement.getResultSet();
//            resultSet.next();
//
//            String description = resultSet.getString(3);
//            guide = new Guide();
//            guide.setDescription(description);
//
//        }catch (Exception e){}

//    }
        return guide;
    }
}
