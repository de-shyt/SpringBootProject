package com.example.springbootproject.controllers;

import com.example.springbootproject.entities.Person;
import com.example.springbootproject.dto.DatabaseEntryDTO;
import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.mappers.DatabaseEntityMapper;
import com.example.springbootproject.mappers.PersonMapper;
import com.example.springbootproject.repositories.MockPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonController {
    // Stores data about the people.
    private final MockPersonRepository repo;

    @Autowired
    public PersonController(MockPersonRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/addPerson")
    public PersonDTO addPerson(@RequestBody PersonDTO from) {
        Person person = repo.add(from.getName(), from.getGender(), from.getAge());
        return person == null ? null : PersonMapper.toPersonDTO(person);
    }

    @GetMapping("/getPersonByName")
    public List<PersonDTO> getPersonByName(@RequestParam String name) {
        List<Person> res = repo.getByName(name);
        return res.isEmpty() ? null : res.stream().map(PersonMapper::toPersonDTO).toList();
    }

    @GetMapping("/getPersonById")
    public PersonDTO getPersonById(@RequestParam Long id) {
        Person person = repo.getById(id);
        return person == null ? null : PersonMapper.toPersonDTO(person);
    }

    @GetMapping("/getAll")
    public List<DatabaseEntryDTO> getAll() {
        return repo.getDatabase().entrySet().stream()
                .map(e ->
                        DatabaseEntityMapper.toDatabaseEntryDTO(e.getKey(), e.getValue()))
                .toList();
    }

    @DeleteMapping("/removePersonById")
    public PersonDTO removePersonById(@RequestParam Long id) {
        Person res = repo.remove(id);
        return res == null ? null : PersonMapper.toPersonDTO(res);
    }
}
