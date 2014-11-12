package com.thoughtworks.letusgo.entity;

import java.util.List;

public class Item{
    private int id;
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private Category category;
    private int discount;
    private List<Promotion> promotionList;

    public Item() {
    }

    public Item(int id, String barcode, String name, String unit, double price, Category category) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
    }
}
