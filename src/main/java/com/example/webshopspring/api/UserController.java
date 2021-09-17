package com.example.webshopspring.api;

import com.example.webshopspring.model.Product;
import com.example.webshopspring.model.User;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping
    public List<User> getAllUsers(){
        return (List<User>) Arrays.asList(
                new User(1,"User1_FirstName","User1_SecondName", "user1@mail.com", "userOnePass", "userOneAddress", false),
                new User(2,"User2_FirstName","User2_SecondName", "user2@mail.com", "userTwoPass", "userTwoAddress", false),
                new User(3,"User3_FirstName","User3_SecondName", "user3@mail.com", "userThreePass", "userThreeAddress", false),
                new User(4,"User4_FirstName","User4_SecondName", "user4@mail.com", "userFourPass", "userFourAddress", true)
                );
    }

    @PostMapping
    public String addUser(){
        return "User added";
    }

    @DeleteMapping
    public String deleteUser(){
        return "User deleted";
    }

    @PutMapping
    public String updateUser(){
        return "User data updated";
    }

}
