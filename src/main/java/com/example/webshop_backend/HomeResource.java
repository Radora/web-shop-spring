package com.example.webshop_backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {


    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome!</>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</>");
    }


}
