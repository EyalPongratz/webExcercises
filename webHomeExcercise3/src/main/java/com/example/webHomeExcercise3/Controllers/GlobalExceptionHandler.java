package com.example.webHomeExcercise3.Controllers;

import com.example.webHomeExcercise3.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise3.Exceptions.NotExistException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // AOP - Aspect Oriented Programing
public class GlobalExceptionHandler {

    @ExceptionHandler({NotExistException.class, AlreadyExistsException.class})
    public ResponseEntity<?> handleException(HttpServletRequest req, Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
