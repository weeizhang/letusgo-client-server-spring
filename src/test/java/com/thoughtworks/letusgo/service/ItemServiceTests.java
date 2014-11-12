package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.ItemDao;
import com.thoughtworks.letusgo.dao.impl.ItemDaoImpl;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import com.thoughtworks.letusgo.service.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceTests {

    private final List<Item> items = new ArrayList<Item>();

    private ItemService itemService;

    @Before
    public void initItems() {
        Item item1 = new Item(1, "Item000001", "雪碧", "瓶", 3.0, new Category(1, "饮料"));
        Item item2 = new Item(2, "Item000002", "可乐", "瓶", 3.0, new Category(1, "饮料"));
        items.add(item1);
        items.add(item2);

        ItemDao mockItemDao = mock(ItemDaoImpl.class);
        when(mockItemDao.getItems()).thenReturn(items);

        itemService = new ItemServiceImpl(mockItemDao);
    }

    @Test
    public void should_return_all_items() {
        List<Item> result = itemService.getItems();
        assertEquals(2, result.size());
    }
}
