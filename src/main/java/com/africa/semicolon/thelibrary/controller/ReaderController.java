package com.africa.semicolon.thelibrary.controller;

import com.africa.semicolon.thelibrary.dtos.requests.RegisterReaderRequest;
import com.africa.semicolon.thelibrary.dtos.responses.ApiResponse;
import com.africa.semicolon.thelibrary.dtos.responses.RegisterReaderResponse;
import com.africa.semicolon.thelibrary.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/reader-controller")
@RequiredArgsConstructor
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @PostMapping("/api/v1/register-reader")
    public ResponseEntity<?> registerReader (RegisterReaderRequest registerReaderRequest){
        try {
            RegisterReaderResponse registerReaderResponse = readerService.registerReader(registerReaderRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerReaderResponse), CREATED);
         } catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
}
