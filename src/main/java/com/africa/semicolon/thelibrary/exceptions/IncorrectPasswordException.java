package com.africa.semicolon.thelibrary.exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String response) {
        super(response);
    }

}
