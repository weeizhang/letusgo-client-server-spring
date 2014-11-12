package com.thoughtworks.letusgo.service.impl;

import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
    }

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
