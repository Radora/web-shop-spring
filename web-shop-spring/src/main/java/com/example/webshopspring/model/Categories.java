package com.example.webshopspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categories {

    private final int id;
    private String name;


    public Categories(int id, String name) {
        this.id = id;
        this.name = name;
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
}
