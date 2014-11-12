package com.thoughtworks.letusgo.service.impl;

import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
    }

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }
}
