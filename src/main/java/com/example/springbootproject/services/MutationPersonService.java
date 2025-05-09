package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;

public interface MutationPersonService {
    PersonDTO increaseAgeByOne(Long id);
    PersonDTO changeName(Long id, String newName);
    PersonDTO changeGender(Long id, String newGender);
}
