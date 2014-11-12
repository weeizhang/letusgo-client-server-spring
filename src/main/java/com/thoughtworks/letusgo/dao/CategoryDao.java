package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();
}
