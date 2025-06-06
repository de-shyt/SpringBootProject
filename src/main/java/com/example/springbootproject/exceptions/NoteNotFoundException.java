package com.example.springbootproject.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Could not find a note with id: " + id);
    }
}
