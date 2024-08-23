package com.africa.semicolon.thelibrary.services;

import com.africa.semicolon.thelibrary.data.model.Reader;
import com.africa.semicolon.thelibrary.data.repository.ReaderRepository;
import com.africa.semicolon.thelibrary.dtos.requests.LoginReaderRequest;
import com.africa.semicolon.thelibrary.dtos.requests.RegisterReaderRequest;
import com.africa.semicolon.thelibrary.dtos.responses.LoginReaderResponse;
import com.africa.semicolon.thelibrary.dtos.responses.RegisterReaderResponse;
import com.africa.semicolon.thelibrary.exceptions.IncorrectPasswordException;
import com.africa.semicolon.thelibrary.exceptions.ReaderAlreadyExistsException;
import com.africa.semicolon.thelibrary.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.thelibrary.utility.Mapper.map;
import static com.africa.semicolon.thelibrary.utility.Mapper.mapLogin;

@Service
public class ReaderServiceImplimentation implements ReaderService{
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public RegisterReaderResponse registerReader(RegisterReaderRequest registerReaderRequest) {
            validateReaderEmail(registerReaderRequest.getEmail());
            Reader reader = new Reader();
            map(registerReaderRequest, reader);
            readerRepository.save(reader);
            return map(reader);
    }

    @Override
    public List<Reader> getAllReader() {
        return readerRepository.findAll();
    }

    @Override
    public LoginReaderResponse login(LoginReaderRequest loginReaderRequest) {
            Reader reader = findByEmail(loginReaderRequest.getEmail());
            validateReaderPassword(loginReaderRequest.getPassword(), reader);
            reader.setLoggedIn(true);
            mapLogin(reader);
            readerRepository.save(reader);
            return mapLogin(reader);
    }
    private Reader findByEmail(String email) {
        return readerRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    private void validateReaderPassword(String passord, Reader reader){
        if (!passord.matches(reader.getPassword())) throw new IncorrectPasswordException("Invalid Details");
    }
    private void validateReaderEmail(String email){
        boolean existsByEmail = readerRepository.existsByEmail(email);
        if (existsByEmail) throw new ReaderAlreadyExistsException("user already exists");
    }
}
