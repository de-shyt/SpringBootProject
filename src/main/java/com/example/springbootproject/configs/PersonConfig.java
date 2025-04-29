package com.example.springbootproject.configs;

import com.example.springbootproject.entities.Animal;
import com.example.springbootproject.entities.Person;
import com.example.springbootproject.services.PersonDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
    @Bean
    public Person mammyTwoShoes(@Autowired Animal catTom, @Autowired PersonDatabase db) {
        return db.add("Mammy Two Shoes", "Female", 36, catTom);
    }
}
