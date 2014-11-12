package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.entity.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getItems();
}
