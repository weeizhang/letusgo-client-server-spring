package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }
}
