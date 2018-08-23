package com.guide_finder.service.impl.category;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.dao.impl.category.CategoryDaoImpl;
import com.guide_finder.model.category.Category;
import com.guide_finder.service.abstraction.category.CategoryService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.categoryDao = new CategoryDaoImpl(connection);
    }

    @Override
    public List<Category> getAllCategories() {

        try (Statement stmt = DBHelper.getConnection().createStatement()) {

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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
