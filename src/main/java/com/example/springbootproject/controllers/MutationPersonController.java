package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.services.MutationPersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MutationPersonController {
    private final MutationPersonService personService;

    @PutMapping("/updateAge")
    public PersonDTO updateAge(@RequestParam("id") Long personId) {
        return personService.increaseAgeByOne(personId);
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
