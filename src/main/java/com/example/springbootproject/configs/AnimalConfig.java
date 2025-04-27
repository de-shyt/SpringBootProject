package com.example.springbootproject.configs;

import com.example.springbootproject.animals.Animal;
import com.example.springbootproject.animals.Cat;
import com.example.springbootproject.animals.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    @Bean
    public Animal mouse() {
        return new Mouse("Jerry", 3);
    }

    @Bean
    public Animal cat() {
        return new Cat("Tom", 5);
    }
}
