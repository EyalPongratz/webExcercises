package com.example.springTest.controllers;


import com.example.springTest.exception.SchoolSystemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // AOP - Aspect Oriented Programing
public class GlobalExceptionHandler {

    @ExceptionHandler({SchoolSystemException.class})
    public ResponseEntity<?> handleException(HttpServletRequest req, Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}