package com.africa.semicolon.thelibrary.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReaderRequest {
    private String email;
    private String password;
}
