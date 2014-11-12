package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/{barcode}", method = RequestMethod.GET)
    public Item getItemByBarcode(@PathVariable String barcode) {
        return itemService.getItemByBarcode(barcode);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeries(@PathVariable("id") int id) {
        itemService.deleteItemById(id);
    }
}
