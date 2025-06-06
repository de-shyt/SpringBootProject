package com.example.springbootproject.exceptions.handlers;

import com.example.springbootproject.dto.response.ErrorResponse;
import com.example.springbootproject.exceptions.NoteNotFoundException;
import com.example.springbootproject.mappers.ErrorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotesExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFoundException(NoteNotFoundException e) {
        ErrorResponse response = ErrorResponseMapper.toNotFoundErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
