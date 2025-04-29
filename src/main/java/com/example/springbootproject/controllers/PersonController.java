package com.example.springbootproject.controllers;

import com.example.springbootproject.entities.Person;
import com.example.springbootproject.entities.json.AnimalJson;
import com.example.springbootproject.entities.json.DatabaseEntryJson;
import com.example.springbootproject.entities.json.PersonJson;
import com.example.springbootproject.entities.json.PersonWithoutAnimalJson;
import com.example.springbootproject.services.ExistingBeansService;
import com.example.springbootproject.services.PersonDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonController {
    // Stores data about the people.
    private final PersonDatabase database;
    // Controls access to the existing beans.
    private final ExistingBeansService existingBeans;

    public PersonController(@Autowired PersonDatabase database, @Autowired ExistingBeansService mammyTwoShoesController) {
        this.database = database;
        this.existingBeans = mammyTwoShoesController;
    }

    @PostMapping("/addPerson")
    public PersonJson addPerson(@RequestBody PersonWithoutAnimalJson from) {
        Person person = database.add(from.getName(), from.getGender(), from.getAge());
        return person == null ? null : new PersonJson(person);
    }

    @GetMapping("/getPersonByName")
    public List<PersonJson> getPersonByName(@RequestParam String name) {
        List<Person> res = database.getByName(name);
        return res.isEmpty() ? null : res.stream().map(PersonJson::new).toList();
    }

    @GetMapping("/getPersonById")
    public PersonJson getPersonById(@RequestParam int id) {
        Person person = database.getById(id);
        return person == null ? null : new PersonJson(person);
    }

    @GetMapping("/getAll")
    public List<DatabaseEntryJson> getAll() {
        return database.getDatabase().entrySet().stream()
                .map(e -> new DatabaseEntryJson(e.getKey(), new PersonJson(e.getValue())))
                .toList();
    }

    @DeleteMapping("/removePersonById")
    public PersonJson removePersonById(@RequestParam int id) {
        Person res = database.remove(id);
        return res == null ? null : new PersonJson(res);
    }


    // Returns a cat "Tom" whose owner is a person "Mammy Two Shoes"
    @GetMapping("/catTom")
    public AnimalJson catTom() {
        return existingBeans.catTom();
    }

    // Returns a person "Mammy Two Shoes" who owns a cat "Tom"
    @GetMapping("/mammyTwoShoes")
    public PersonJson mammyTwoShoes() {
        return existingBeans.mammyTwoShoesPerson();
    }
}
