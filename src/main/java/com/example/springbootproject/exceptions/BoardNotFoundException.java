package com.example.springbootproject.exceptions;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(Long id) {
        super("Could not find a board with id: " + id);
    }
}
