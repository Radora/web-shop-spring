package com.example.webshopspring.model;

import java.util.Date;

public class Basket {

    private final int id;
    private final User user;
    private Date dateAdded;

    private Product product;
    private int productQuantity;


    public Basket(int id, User user, Date dateAdded, Product product, int productQuantity) {
        this.id = id;
        this.user = user;
        this.dateAdded = dateAdded;
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
