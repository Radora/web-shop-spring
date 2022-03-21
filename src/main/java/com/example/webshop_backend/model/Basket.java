package com.example.webshop_backend.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int id;

//    @OneToOne
//    @JoinColumn(name = "userid",insertable = false,updatable = false)
//    private User user;

    @OneToMany(mappedBy = "basket", cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
    private List<BasketItem> basketItems = new ArrayList<>();

    public Basket() {
    }

    public Basket(List<BasketItem> basketItems) {
        super();
        this.basketItems = basketItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
}
