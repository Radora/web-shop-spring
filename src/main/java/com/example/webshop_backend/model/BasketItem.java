package com.example.webshop_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    public Product product;

    @Positive
    @Min(1)
    private int productQuantity;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public BasketItem(BasketItem basketItem) {
        this.product = basketItem.getProduct();
        this.productQuantity = basketItem.getProductQuantity();
    }
    @JsonBackReference
    public Basket getBasket(){
        return basket;
    }
}
