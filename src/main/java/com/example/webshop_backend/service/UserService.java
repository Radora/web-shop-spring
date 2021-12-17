package com.example.webshop_backend.service;

import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
