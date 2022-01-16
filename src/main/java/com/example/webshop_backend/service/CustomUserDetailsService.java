package com.example.webshop_backend.service;

import com.example.webshop_backend.model.MyUserDetails;
import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found!"));

        return user.map(MyUserDetails::new).get();

    }
}
