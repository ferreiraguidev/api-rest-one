package com.example.apirestone.exceptions.handler;

import com.example.apirestone.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionFilters handlerUserNotFound(final UserNotFoundException ex){
        return ExceptionFilters.builder()
                .title("User Not Found")
                .details(ex.getMessage())
                .status(NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }






}
