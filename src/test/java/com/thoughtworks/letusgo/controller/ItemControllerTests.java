package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemControllerTests {
    private ItemController itemController;

    private ItemService itemService;

    private final List<Item> items = new ArrayList<Item>();

    @Before
    public void before() {
        itemService = mock(ItemService.class);
        Item item1 = new Item(1, "Item000001", "雪碧", "瓶", 3.0, new Category(1, "饮料"));
        Item item2 = new Item(2, "Item000002", "可乐", "瓶", 3.0, new Category(1, "饮料"));
        items.add(item1);
        items.add(item2);
        when(itemService.getItems()).thenReturn(items);

        when(itemService.getItemById(1)).thenReturn(item1);
        itemController = new ItemController();

        ReflectionTestUtils.setField(itemController, "itemService", itemService);
    }

    @Test
    public void should_return_all_items() {
        assertThat(itemController.getItems().get(0).getName()).isEqualTo("雪碧");
    }

    @Test
    public void should_return_item_by_id() {
        assertThat(itemController.getItemById(1).getName()).isEqualTo("雪碧");
    }

    @Test
    public void should_delete_item_by_id() {
        itemController.deleteItemById(1);
        verify(itemService).deleteItemById(1);
    }

    @Test
    public void should_add_item() {
        Item item = new Item(3, "Item000003", "果粒橙", "瓶", 3.0, new Category(1, "饮料"));
        itemController.addItem(item);
        verify(itemService).addItem(item);
    }

    @Test
    public void should_update_item() {
        Item item = new Item(2, "Item000002", "果粒橙", "瓶", 3.0, new Category(1, "饮料"));
        itemController.updateItem(2, item);
        verify(itemService).updateItem(2, item);
    }
}
