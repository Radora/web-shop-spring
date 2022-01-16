package com.example.webshop_backend.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http // "/(home)" accessible by everybody
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();

        http // "/admin" accessible by user with ROLE_ADMIN
                .authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ADMIN')");


        http // "/user" accessible by user with ADMIN or USER roles
                .authorizeRequests()
                .antMatchers("/user")
                .hasAnyRole("ADMIN", "USER");

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


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
