package com.guide_finder.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    static public Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        DriverManager.registerDriver((Driver) Class.forName(PropertyReader.getProperties("driver.class")).newInstance());
        DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

        String url = PropertyReader.getProperties("connection.url") + "?user=" +
                PropertyReader.getProperties("username") + "&password=" +
                PropertyReader.getProperties("password");

        return DriverManager.getConnection(url);

    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
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
}
