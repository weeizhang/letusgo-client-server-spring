package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryControllerTests {
    private CategoryController categoryController;

    private CategoryService categoryService;

    private final List<Category> categories = new ArrayList<Category>();

    @Before
    public void before() {
        categoryService = mock(CategoryService.class);
        Category category1 = new Category(1, "饮料");
        Category category2 = new Category(2, "水果");
        categories.add(category1);
        categories.add(category2);
        when(categoryService.getCategories()).thenReturn(categories);

        when(categoryService.getCategoryById(1)).thenReturn(category1);
        categoryController = new CategoryController();

        ReflectionTestUtils.setField(categoryController, "categoryService", categoryService);
    }

    @Test
    public void should_return_all_categories() {
        assertThat(categoryController.getCategories().get(0).getName()).isEqualTo("饮料");
    }

    @Test
    public void should_return_category_by_id() {
        assertThat(categoryController.getCategoryById(1).getName()).isEqualTo("饮料");
    }

    @Test
    public void should_delete_category_by_id() {
        categoryController.deleteCategoryById(1);
        verify(categoryService).deleteCategoryById(1);
    }

    @Test
    public void should_add_category() {
        Category category = new Category(3, "生活用品");
        categoryController.addCategory(category);
        verify(categoryService).addCategory(category);
    }

    @Test
    public void should_update_category() {
        Category category = new Category(3, "生活用品");
        categoryController.updateCategory(2, category);
        verify(categoryService).updateCategory(2, category);
    }
}
