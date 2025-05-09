package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;

public interface BasePersonService {
    PersonDTO create(PersonDTO personDTO);
    void remove(Long id);
}
