package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();

    Category getCategoryById(int id);

    void deleteCategoryById(int id);
}
