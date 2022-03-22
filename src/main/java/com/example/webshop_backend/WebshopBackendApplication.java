package com.example.webshop_backend;

import com.example.webshop_backend.property.FileStorageProperties;
import com.example.webshop_backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
@EnableConfigurationProperties({FileStorageProperties.class})
public class WebshopBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopBackendApplication.class, args);
    }

}
