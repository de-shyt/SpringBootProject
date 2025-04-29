package com.example.springbootproject.services;

import com.example.springbootproject.entities.Animal;
import com.example.springbootproject.entities.Person;
import com.example.springbootproject.entities.json.AnimalJson;
import com.example.springbootproject.entities.json.PersonJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 Stores the existing beans.
 */
@Service
public class ExistingBeansService {
    // A person "Mammy Two Shoes" who owns a cat "Tom"
    private final PersonJson mammyTwoShoesPerson;
    // A cat "Tom" whose owner is a person "Mammy Two Shoes"
    private final AnimalJson catTom;

    public ExistingBeansService(@Autowired Person mammyTwoShoesPerson, @Autowired Animal catTom) {
        this.mammyTwoShoesPerson = new PersonJson(mammyTwoShoesPerson);
        this.catTom = new AnimalJson(catTom);
    }

    public PersonJson mammyTwoShoesPerson() {
        return mammyTwoShoesPerson;
    }

    public AnimalJson catTom() {
        return catTom;
    }
}
