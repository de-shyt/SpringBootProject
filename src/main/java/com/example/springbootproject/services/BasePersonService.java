package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;

public interface BasePersonService {
    PersonDTO create(PersonDTO personDTO);
    PersonDTO remove(Long id);
}
