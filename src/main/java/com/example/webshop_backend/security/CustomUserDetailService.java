package com.example.webshop_backend.security;

import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        if (null == user) { throw new UsernameNotFoundException(s); }
        return new CustomUserDetails(user);
    }
}