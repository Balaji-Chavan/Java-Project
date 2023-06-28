package com.project.BookMyCinemaProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> res = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> res.put(((FieldError) error).getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleNotValidationException( ConstraintViolationException ex) {





        return new ResponseEntity<>(ex.getConstraintViolations().toString(), HttpStatus.BAD_REQUEST);
    }
}
