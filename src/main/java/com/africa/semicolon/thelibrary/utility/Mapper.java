package com.africa.semicolon.thelibrary.utility;

import com.africa.semicolon.thelibrary.data.model.Reader;
import com.africa.semicolon.thelibrary.dtos.requests.LoginReaderRequest;
import com.africa.semicolon.thelibrary.dtos.requests.RegisterReaderRequest;
import com.africa.semicolon.thelibrary.dtos.responses.LoginReaderResponse;
import com.africa.semicolon.thelibrary.dtos.responses.RegisterReaderResponse;

public class Mapper {
    public static void map(RegisterReaderRequest registerReaderRequest, Reader reader){
        reader.setEmail(registerReaderRequest.getEmail());
        reader.setPassword(registerReaderRequest.getPassword());
        reader.setPhoneNumber(registerReaderRequest.getPhoneNumber());
        reader.setUsername(registerReaderRequest.getUsername());
    }
    public static RegisterReaderResponse map(Reader reader){
        RegisterReaderResponse registerReaderResponse = new RegisterReaderResponse();
        registerReaderResponse.setId(reader.getId());
        registerReaderResponse.setEmail(reader.getEmail());
        registerReaderResponse.setMessage("Successfully registered");
        return registerReaderResponse;
    }
    public static void mapLogin (LoginReaderRequest loginReaderRequest, Reader reader){
        reader.setEmail(loginReaderRequest.getEmail());
        reader.setPassword(loginReaderRequest.getPassword());

    }
    public static LoginReaderResponse mapLogin(Reader reader){
        LoginReaderResponse loginReaderResponse = new LoginReaderResponse();
        loginReaderResponse.setEmail(reader.getEmail());
        loginReaderResponse.setMessage("Successfully loggedIn");
        loginReaderResponse.setLoggedIn(reader.isLoggedIn());
        return loginReaderResponse;
    }
}
