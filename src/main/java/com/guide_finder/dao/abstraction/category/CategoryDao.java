package com.guide_finder.dao.abstraction.category;

import com.guide_finder.model.category.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    Category getCategoryById(long id) throws SQLException;
    Category getCategoryByName(String name) throws SQLException;
    void addCategory(Category category);
    void removeCategoryById(long id) throws SQLException;
    void updateCategoryById(long id, String name, String description) throws SQLException;
    List<Category> getAllCategories();
}
