package com.guide_finder.dao.impl.category;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.category.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final Executor executor;
    public CategoryDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }


    @Override
    public Category getCategoryById(long id) throws SQLException {
        {
            return executor.execQuery("SELECT * FROM category WHERE id='" + id + "'", result -> {
                result.next();
                return new Category(
                        result.getString(2),
                        result.getString(3)
                );
            });
        }
    }

    @Override
    public Category getCategoryByName(String name) throws SQLException {
            return executor.execQuery("SELECT * FROM category WHERE category='" + name + "'", result -> {
                result.next();
                return new Category(
                        result.getString(2),
                        result.getString(3)
                );
            });
        }


    @Override
    public void addCategory(Category category) {
        String categoryName = category.getName();
        String categoryDescription = category.getDescription();
        executor.execUpdate("INSERT INTO category (category, description) VALUES ('"
                + categoryName + "', '" + categoryDescription + "')");
    }

    @Override
    public void removeCategoryById(long id) throws SQLException {
        executor.execUpdate("DELETE FROM category WHERE id='" + id + "'");
    }

    @Override
    public void updateCategoryById(long id, String name, String description) throws SQLException {
        executor.execUpdate("UPDATE category SET category='" + name
                        + "', description='" + description
                        + "' WHERE id='" + id + "'");
    }

    @Override
    public List<Category> getAllCategories() {
        return executor.execQuery("SELECT * FROM category;",
                result -> {
                    List<Category> CategoryList = new ArrayList<>();
                    while (result.next()) {
                        CategoryList.add(
                                new Category(
                                        result.getString(2),
                                        result.getString(3)
                                ));
                    }
                    return CategoryList;
                });
    }


}
