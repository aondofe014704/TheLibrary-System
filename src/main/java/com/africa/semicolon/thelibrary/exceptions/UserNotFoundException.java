package com.africa.semicolon.thelibrary.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String response){
        super(response);
    }
}
