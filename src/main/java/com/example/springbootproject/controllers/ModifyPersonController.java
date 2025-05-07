package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.services.ModifyPersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ModifyPersonController {
    private final ModifyPersonService personService;

    @PutMapping("/updateAge/{id}")
    public PersonDTO updateAge(@PathVariable("id") Long id) {
        return personService.increaseAgeByOne(id);
    }

    @PutMapping("/changeName")
    public PersonDTO changeName(@RequestParam("id") Long personId,
                                @RequestParam("name") String newName) {
        return personService.changeName(personId, newName);
    }

    @PutMapping("/changeGender")
    public PersonDTO changeGender(@RequestParam("id") Long personId,
                                  @RequestParam("gender") String newGender) {
        return personService.changeGender(personId, newGender);
    }
}
