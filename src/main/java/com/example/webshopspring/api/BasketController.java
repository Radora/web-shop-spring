package com.example.webshopspring.api;


import com.example.webshopspring.model.Basket;
import com.example.webshopspring.model.Product;
import com.example.webshopspring.model.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequestMapping("/basket")
@RestController
public class BasketController {

    @GetMapping
    public List<Basket> getAllBaskets(){

        return Arrays.asList(
                new Basket(1, new User(1,"User1_FirstName","User1_SecondName", "user1@mail.com", "userOnePass", "userOneAddress", false),
                        new Date(), new Product(1,"Iphone 8", "Iphone 8 description", new BigDecimal("599.99"), 8), 2),
                new Basket(1, new User(2,"User2_FirstName","User2_SecondName", "user2@mail.com", "userTwoPass", "userTwoAddress", false),
                        new Date(), new Product(3,"Huawei P40", "Huawei P40 description", new BigDecimal("449.99"), 9), 1)
        );
    }

    @PostMapping
    public String addProductToBasket(){
        return "Product added to dsdqwqdq basket";
    }

    @DeleteMapping
    public String deleteProductFromBasket(){
        return "Product removed from  basket";
    }

    @PutMapping
    public String updateBasket(){
        return "Basket data updated";
    }

}
