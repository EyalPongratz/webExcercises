package com.example.webHomeVersion2.Exceptions;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Element not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
