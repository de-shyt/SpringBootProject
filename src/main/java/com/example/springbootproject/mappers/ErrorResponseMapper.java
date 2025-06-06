package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponseMapper {
    public static ErrorResponse toNotFoundErrorResponse(String message) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, message);
    }

    public static ErrorResponse toBadRequestErrorResponse(String message) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, message);
    }
}
