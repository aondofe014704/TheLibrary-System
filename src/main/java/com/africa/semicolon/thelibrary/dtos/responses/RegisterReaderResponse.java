package com.africa.semicolon.thelibrary.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterReaderResponse {
    private String id;
    private String email;
    private String message;
}
