package com.example.webshop_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "userid",insertable = false,updatable = false)
    private User user;

    @OneToMany
    private List<Product> products;

    @Positive
    @Min(1)
    private int productQuantity;


}
