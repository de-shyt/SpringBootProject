package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.services.QueryPersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QueryPersonController {
    private final QueryPersonService personService;

    @GetMapping("getPersonByName")
    public List<PersonDTO> getPersonByName(@RequestParam("name") String personName) {
        return personService.getByName(personName);
    }

    @GetMapping("getPersonById")
    public PersonDTO getPersonById(@RequestParam("id") Long personId) {
        return personService.getById(personId);
    }

    @GetMapping("/getByAgeInRange")
    public List<PersonDTO> getByAgeInRange(@RequestParam("min") int minAge,
                                           @RequestParam("max") int maxAge) {
        return personService.getByAgeInRange(minAge, maxAge);
    }

    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }
}
