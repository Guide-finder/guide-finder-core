package com.guide_finder.dao.impl.category;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.model.category.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CategoryDaoImpl implements CategoryDao {

    private final Connection connection;

    @Override
    public List<Category> getAllCategories() {

        try (Statement stmt = connection.createStatement()) {

            List<Category> categories = new ArrayList<>();
            String sql = "select name, description from guide_finder.category";
            stmt.execute(sql);

            try (ResultSet result = stmt.getResultSet()) {

                while (!result.isLast()) {
                    result.next();
                    System.out.println();
                    categories.add(new Category(result.getString("name"), result.getString("description")));
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }

            return categories;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return null;
    }

//    static public Connection getMysqlConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//
//        DriverManager.registerDriver((Driver) Class.forName(PropertiesReader.getProperties("driver.class")).newInstance());
//
//        String url = PropertiesReader.getProperties("connection.url") + "?user=" +
//                PropertiesReader.getProperties("username") + "&password=" +
//                PropertiesReader.getProperties("password");
//
//        return DriverManager.getConnection(url);
//
//    }

    public CategoryDaoImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guide_finder", "root", "root");
    }
}
