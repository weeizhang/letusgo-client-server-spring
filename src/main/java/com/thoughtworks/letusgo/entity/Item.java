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
}
