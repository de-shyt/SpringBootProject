package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.services.BasePersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class BasePersonController {
    private final BasePersonService personService;

    @PostMapping("/addPerson")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @DeleteMapping("/removePersonById/{id}")
    public void removePersonById(@PathVariable("id") Long personId) {
        personService.remove(personId);
    }
}
