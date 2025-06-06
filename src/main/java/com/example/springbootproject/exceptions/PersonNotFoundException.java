package com.example.springbootproject.exceptions;


public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Could not find a person with id: " + id);
    }
}
