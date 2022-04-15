package com.example.spring.api.exceptions;

public class UserAlredyExists extends Exception{
    public UserAlredyExists(String message) {
        super(message);
    }
}
