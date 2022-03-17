package com.example.webshop_backend.model;

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




}
