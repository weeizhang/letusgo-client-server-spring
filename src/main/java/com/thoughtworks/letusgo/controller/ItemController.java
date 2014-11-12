package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @RequestMapping(value="{barcode}", method = RequestMethod.GET)
    public Item getItemByBarcode(@PathVariable String barcode) {
        return itemService.getItemByBarcode(barcode);
    }
}
