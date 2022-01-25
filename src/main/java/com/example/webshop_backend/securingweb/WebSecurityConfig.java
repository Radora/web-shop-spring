package com.example.webshop_backend.securingweb;

import com.example.webshop_backend.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final CustomUserDetailService customUserDetailService;

    public WebSecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http // "/(home)" accessible by everybody
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();

        http // "/(home)" accessible by everybody
                .authorizeRequests()
                .antMatchers("templates/register.html")
                .permitAll();

        http // "/(home)" accessible by everybody
                .authorizeRequests()
                .antMatchers("/registerSuccess")
                .permitAll();

        http // "/admin" accessible by user with ROLE_ADMIN
                .authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ADMIN')");


        http // "/user" accessible by user with ADMIN or USER roles
                .authorizeRequests()
                .antMatchers("/user")
                .hasAnyRole("ADMIN", "USER");

        /*http // lock every route
                .authorizeRequests()
                .anyRequest()
                .authenticated();*/
        //commented out for testing purposes

        http //CSRF abschalten
                .csrf()
                .disable();

        http //Login einrichten
                .formLogin()
                .loginProcessingUrl("templates/login.html")
                .permitAll();

        http //Logout einrichten
                .logout()
                .logoutUrl("/logout")
                .permitAll();
        http
                .addFilterAt(
                        usernamePasswordAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                );
        http
                .exceptionHandling()
                .accessDeniedHandler(
                        (httpServletRequest, httpServletResponse, e) ->
                                httpServletResponse.sendError(
                                        HttpServletResponse.SC_FORBIDDEN
                                )
                )
                .authenticationEntryPoint(
                        new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
                );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return this.customUserDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter()
            throws Exception {
        JsonUsernamePasswordAuthenticationFilter authenticationFilter
                = new JsonUsernamePasswordAuthenticationFilter();
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:63342", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}