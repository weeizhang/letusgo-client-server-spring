package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategoryById(int i);

    void deleteCategoryById(int i);

    void addCategory(Category category);

    void updateCategory(int id, Category category);
}
