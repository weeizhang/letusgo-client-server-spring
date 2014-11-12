package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.entity.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getItems();

    Item getItemById(int id);

    void deleteItemById(int i);

    void addItem(Item item);

    void updateItem(int id, Item item);
}
