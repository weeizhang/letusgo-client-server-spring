package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.entity.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItemByBarcode(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemById(@PathVariable("id") int id) {
        itemService.deleteItemById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable("id") int id, @RequestBody Item item) {
        itemService.updateItem(id, item);
    }
}
