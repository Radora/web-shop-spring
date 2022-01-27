package com.example.webshop_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@ManyToOne
    @JoinColumn(name = "categoryid",insertable = false,updatable = false)*/

    //@NotEmpty
    private String category;

    //@NotBlank
    //@NotNull
    private String name;

    //private int categoryid;

    //@NotBlank
    //@NotNull
    private String description;

    //@Positive
    private float price;

    //@Positive
    private int product_stock;
}
