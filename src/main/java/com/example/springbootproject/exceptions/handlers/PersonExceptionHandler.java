package com.example.springbootproject.exceptions.handlers;

import com.example.springbootproject.exceptions.PersonNotFoundException;
import com.example.springbootproject.mappers.ErrorResponseMapper;
import com.example.springbootproject.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException e) {
        ErrorResponse response = ErrorResponseMapper.toNotFoundErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
