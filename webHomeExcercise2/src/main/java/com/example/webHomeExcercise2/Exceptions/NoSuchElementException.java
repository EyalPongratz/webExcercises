package com.example.webHomeExcercise2.Exceptions;

public class NoSuchElementException extends Exception{
    public NoSuchElementException() {
        super("No such element");
    }
    public NoSuchElementException(String message) {
        super(message);
    }
}
