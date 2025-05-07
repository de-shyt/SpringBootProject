package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;

import java.util.List;

public interface GetPersonService {
    PersonDTO getById(Long id);
    List<PersonDTO> getByName(String name);
    List<PersonDTO> getByAgeInRange(int minAge, int maxAge);
    List<PersonDTO> getAll();
}
