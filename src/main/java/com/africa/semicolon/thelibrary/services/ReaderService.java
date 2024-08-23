package com.africa.semicolon.thelibrary.services;


import com.africa.semicolon.thelibrary.data.model.Reader;
import com.africa.semicolon.thelibrary.dtos.requests.LoginReaderRequest;
import com.africa.semicolon.thelibrary.dtos.requests.RegisterReaderRequest;
import com.africa.semicolon.thelibrary.dtos.responses.LoginReaderResponse;
import com.africa.semicolon.thelibrary.dtos.responses.RegisterReaderResponse;

import java.util.Collection;
import java.util.List;

public interface ReaderService {


    RegisterReaderResponse registerReader(RegisterReaderRequest registerReaderRequest);

    List<Reader> getAllReader();

    LoginReaderResponse login(LoginReaderRequest loginReaderRequest);
}
