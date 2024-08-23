package com.africa.semicolon.thelibrary.dtos.requests;

import com.africa.semicolon.thelibrary.data.model.ReaderType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterReaderRequest {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private ReaderType readerType;
}
