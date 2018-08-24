package com.guide_finder.dao.impl.role;

import com.guide_finder.dao.impl.UserDaoImpl;

import com.guide_finder.model.user.Guide;
import com.guide_finder.model.user.User;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GuideDaoImpl {

    private UserDaoImpl userDao;
    Connection connection;
    Guide guide;

    public GuideDaoImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.connection = DBHelper.getConnection();
    }

    public Guide getGuideById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String guideData = String.format("select * from guide where user_id='%s'",id);
        statement.executeQuery(guideData);
        try{
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            String description = resultSet.getString(3);
            guide = new Guide();
            guide.setDescription(description);

        }catch (Exception e){}

        return guide;
    }

}
