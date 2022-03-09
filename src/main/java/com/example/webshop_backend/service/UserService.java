package com.example.webshop_backend.service;

import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public String saveUser(User userToCreate){
       User user = new User();
       user.setUsername(userToCreate.getUsername());
       user.setFirstname(userToCreate.getFirstname());
       user.setSurname(userToCreate.getSurname());
       user.setRoles("ROLE_USER");
       user.setEmail(userToCreate.getEmail());
       user.setAddress(userToCreate.getAddress());
       user.setActive(true);
       String passwordEncoded = bCryptPasswordEncoder.encode(userToCreate.getPassword());
       user.setPassword(passwordEncoded);
       userRepository.save(user);
        return "new User added";
    }
    public User updateUser(User userToUpdate){
        String passwordEncoded = bCryptPasswordEncoder.encode(userToUpdate.getPassword());
        userToUpdate.setPassword(passwordEncoded);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
    public List<User> getUser(){
        return (List<User>) userRepository.findAll();
    }
    public Optional<User> findById(int id){
        return userRepository.findById((long) id);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void deleteUser(int id){
        userRepository.deleteById((long) id);
    }
}
