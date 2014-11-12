package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.dao.impl.CategoryDaoImpl;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.service.impl.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryServiceTests {
    private final List<Category> categories = new ArrayList<Category>();

    private CategoryService categoryService;
    private CategoryDao mockCategoryDao;

    @Before
    public void initCategories() {
        Category category1 = new Category(1, "饮料");
        Category category2 = new Category(2, "水果");
        categories.add(category1);
        categories.add(category2);

        mockCategoryDao = mock(CategoryDaoImpl.class);
        when(mockCategoryDao.getCategories()).thenReturn(categories);
        when(mockCategoryDao.getCategoryById(2)).thenReturn(category2);

        categoryService = new CategoryServiceImpl(mockCategoryDao);
    }

    @Test
    public void should_return_all_categories() {
        List<Category> result = categoryService.getCategories();
        assertEquals(2, result.size());
    }

    @Test
    public void should_return_category_by_id() {
        Category result = categoryService.getCategoryById(2);
        assertEquals("水果", result.getName());
    }

}
