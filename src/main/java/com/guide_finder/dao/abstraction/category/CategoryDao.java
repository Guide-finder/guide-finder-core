package com.guide_finder.dao.abstraction.category;


import com.guide_finder.model.category.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAllCategories();

}
