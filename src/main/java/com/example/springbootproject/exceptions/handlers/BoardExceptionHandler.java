package com.example.springbootproject.exceptions.handlers;

import com.example.springbootproject.dto.response.ErrorResponse;
import com.example.springbootproject.exceptions.BoardNotFoundException;
import com.example.springbootproject.mappers.ErrorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BoardExceptionHandler {
    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBoardNotFoundException(BoardNotFoundException e) {
        ErrorResponse response = ErrorResponseMapper.toNotFoundErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
