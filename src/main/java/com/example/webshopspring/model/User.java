package com.example.webshopspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final int id;
    private String firstname;
    private String surname;
    private String email;
    private String pwd;
    private String address;
    private boolean isAdmin;

    public User(int id, String firstname, String surname, String email, String pwd, String address, boolean isAdmin) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.pwd = pwd;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
