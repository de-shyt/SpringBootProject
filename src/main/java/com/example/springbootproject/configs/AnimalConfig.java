package com.example.springbootproject.configs;

import com.example.springbootproject.entities.Animal;
import com.example.springbootproject.entities.Cat;
import com.example.springbootproject.entities.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    @Bean
    public Animal mouseJerry() {
        return new Mouse("Jerry", 3);
    }

    @Bean
    public Animal catTom() {
        return new Cat("Tom", 5);
    }
}
