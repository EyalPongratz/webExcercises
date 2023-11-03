package com.example.webHomeExcercise2.Exceptions;

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException() {
        super("Element already exists");
    }
    public AlreadyExistsException(String message) {
        super(message);
    }
}
