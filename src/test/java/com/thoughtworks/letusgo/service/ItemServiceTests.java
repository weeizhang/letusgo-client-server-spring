package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.ItemDao;
import com.thoughtworks.letusgo.dao.impl.ItemDaoImpl;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceTests {

    private final List<Item> items = new ArrayList<Item>();

    @Autowired
    private ItemService itemService;

    @Before
    public void initItems() {
        Item item1 = new Item(1, "Item000001", "雪碧", "瓶", 3.0, new Category(1, "饮料"));
        Item item2 = new Item(2, "Item000002", "可乐", "瓶", 3.0, new Category(1, "饮料"));
        items.add(item1);
        items.add(item2);
    }

    @Test
    public void get_items_service_test() {
        ItemDao mockItemDao = mock(ItemDaoImpl.class);
        when(mockItemDao.getItems()).thenReturn(items);

        List<Item> result = itemService.getItems();

        assertEquals(1, result.size());
    }
}
