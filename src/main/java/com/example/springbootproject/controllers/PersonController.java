package com.example.springbootproject.controllers;

import com.example.springbootproject.entities.Person;
import com.example.springbootproject.dto.DatabaseEntryDTO;
import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.repositories.MockPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonController {
    // Stores data about the people.
    private final MockPersonRepository database;

    @Autowired
    public PersonController(MockPersonRepository database) {
        this.database = database;
    }

    @PostMapping("/addPerson")
    public PersonDTO addPerson(@RequestBody PersonDTO from) {
        Person person = database.add(from.getName(), from.getGender(), from.getAge());
        return person == null ? null : new PersonDTO(person);
    }

    @GetMapping("/getPersonByName")
    public List<PersonDTO> getPersonByName(@RequestParam String name) {
        List<Person> res = database.getByName(name);
        return res.isEmpty() ? null : res.stream().map(PersonDTO::new).toList();
    }

    @GetMapping("/getPersonById")
    public PersonDTO getPersonById(@RequestParam int id) {
        Person person = database.getById(id);
        return person == null ? null : new PersonDTO(person);
    }

    @GetMapping("/getAll")
    public List<DatabaseEntryDTO> getAll() {
        return database.getDatabase().entrySet().stream()
                .map(e -> new DatabaseEntryDTO(e.getKey(), new PersonDTO(e.getValue())))
                .toList();
    }

    @DeleteMapping("/removePersonById")
    public PersonDTO removePersonById(@RequestParam int id) {
        Person res = database.remove(id);
        return res == null ? null : new PersonDTO(res);
    }
}
