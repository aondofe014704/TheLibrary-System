package com.africa.semicolon.thelibrary.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReaderResponse {
    private boolean isLoggedIn;
    private String message;
    private String email;

}
