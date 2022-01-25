package com.example.webshop_backend.api;

import com.example.webshop_backend.model.User;
import com.example.webshop_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> getAllUsers(){
       return userService.getUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable @Valid Integer id){
        return userService.findById(id);
    }

    @PostMapping("/register")
    public String addUser(@RequestBody @Valid User user){
        userService.saveUser(user);
        return "New user added!";
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
        //  User user = UserService.findById(id)
        //  .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
        userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userEdited){
        User user = userService.findById(id)
        //User user = userRepository.findById(id)
        .orElseThrow(() -> new NullPointerException("User does not exist with id :" + id));
        user.setFirstname(userEdited.getFirstname());
        user.setSurname(userEdited.getSurname());
        user.setUsername(userEdited.getUsername());
        user.setEmail(userEdited.getEmail());
        user.setAddress(userEdited.getAddress());
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
}
