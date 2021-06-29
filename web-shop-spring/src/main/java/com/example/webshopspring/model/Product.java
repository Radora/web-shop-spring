package com.example.webshopspring.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Product {

    private final int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int product_stock;

    public Product(int id, String name, String description, BigDecimal price, int product_stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.product_stock = product_stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }
}
