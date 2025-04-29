package com.example.springbootproject.services;

import com.example.springbootproject.entities.Animal;
import com.example.springbootproject.entities.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MammyTwoShoes extends Human {

    public MammyTwoShoes(@Autowired Animal catTom) {
        super("Mammy Two Shoes", "Female", 36);
        this.setAnimal(catTom);
        catTom.setOwner(this);
    }

    @GetMapping("/mammyTwoShoes")
    public Animal mammyTwoShoes(){
        return animal;
    }
}
