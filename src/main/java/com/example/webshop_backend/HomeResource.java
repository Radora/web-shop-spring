package com.example.webshop_backend;


import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeResource {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String home() {
        return ("index");
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user" , new User());
        return ("register");
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user" , new User());
        return ("login");
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        repository.save(user);
        return "registerSuccess";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return ("<h1>Welcome User</>");
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return ("<h1>Welcome Admin</>");
    }


}
