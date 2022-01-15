package com.example.webshop_backend.securingweb;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http // "/home" accessible by everybody
                .authorizeRequests()
                .antMatchers("/home")
                .permitAll();

        http // "/admin" accessible by user with ROLE_ADMIN
                .authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ROLE_ADMIN')");

        http // lock every route
                .authorizeRequests()
                .anyRequest()
                .authenticated();


        http //CSRF abschalten
                .csrf()
                .disable();

        http //Login einrichten
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll();

        http //Login einrichten
                .logout()
                .logoutUrl("/logout")
                .permitAll();

    }


}
