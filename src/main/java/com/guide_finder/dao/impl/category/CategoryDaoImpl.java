package com.guide_finder.dao.impl.category;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.model.category.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CategoryDaoImpl implements CategoryDao {

    private final Connection connection;

    public CategoryDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Category> getAllCategories() {

        try (Statement stmt = connection.createStatement()) {

            List<Category> categories = new ArrayList<>();
            String sql = "select name, description from guide_finder.category";
            stmt.execute(sql);

            try (ResultSet result = stmt.getResultSet()) {

                while (!result.isLast()) {
                    result.next();
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
}
