package com.example.springbootproject.services;

import com.example.springbootproject.animals.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MammyTwoShoes extends Human {

    public MammyTwoShoes(@Autowired Animal cat) {
        super("Mammy Two Shoes", "Female", 36, cat);
        cat.setOwner(this);
    }

    @GetMapping("/mammyTwoShoes")
    public Animal mammyTwoShoes(){
        return animal;
    }
}
