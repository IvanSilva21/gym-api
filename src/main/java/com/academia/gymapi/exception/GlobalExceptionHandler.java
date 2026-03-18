package com.academia.gymapi.exception;

import com.academia.gymapi.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(ResourceNotFoundException ex) {

        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(404)
                .message(ex.getMessage())
                .build();
    }
}
