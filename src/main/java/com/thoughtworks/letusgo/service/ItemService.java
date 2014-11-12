package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item getItemByBarcode(String barcode);

    void deleteItemById(int i);
}
