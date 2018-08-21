package com.guide_finder.service.impl.category;

import com.guide_finder.dao.abstraction.category.CategoryDao;
import com.guide_finder.dao.impl.category.CategoryDaoImpl;
import com.guide_finder.model.category.Category;
import com.guide_finder.service.abstraction.category.CategoryService;

import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
