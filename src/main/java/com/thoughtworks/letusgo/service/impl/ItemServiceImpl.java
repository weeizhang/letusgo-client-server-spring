package com.thoughtworks.letusgo.service.impl;

import com.thoughtworks.letusgo.dao.ItemDao;
import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    public ItemServiceImpl() {
    }

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public Item getItemByBarcode(String barcode) {
        return itemDao.getItemByBarcode(barcode);
    }

    @Override
    public void deleteItemById(int i) {
        itemDao.deleteItemById(i);
    }

    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public void updateItem(int id, Item item) {
        itemDao.updateItem(id, item);
    }
}
