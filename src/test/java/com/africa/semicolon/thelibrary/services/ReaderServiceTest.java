package com.africa.semicolon.thelibrary.services;

import com.africa.semicolon.thelibrary.data.model.ReaderType;
import com.africa.semicolon.thelibrary.data.repository.ReaderRepository;
import com.africa.semicolon.thelibrary.dtos.requests.AddBookRequest;
import com.africa.semicolon.thelibrary.dtos.requests.LoginReaderRequest;
import com.africa.semicolon.thelibrary.dtos.requests.RegisterReaderRequest;
import com.africa.semicolon.thelibrary.dtos.responses.AddBookResponse;
import com.africa.semicolon.thelibrary.dtos.responses.LoginReaderResponse;
import com.africa.semicolon.thelibrary.dtos.responses.RegisterReaderResponse;
import com.africa.semicolon.thelibrary.exceptions.ReaderAlreadyExistsException;
import com.africa.semicolon.thelibrary.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ReaderServiceTest {
    @Autowired
    private ReaderService readerService;
    @Autowired
    private ReaderRepository readerRepository;

    @BeforeEach
    public void setUp(){
        readerRepository.deleteAll();
    }

    @Test
    public void testToRegisterAReader(){
        RegisterReaderResponse registerReaderResponse = createNewRegister();
        assertThat(registerReaderResponse).isNotNull();
        assertThat(readerService.getAllReader().size()).isEqualTo(1L);
        assertThat(registerReaderResponse.getMessage().contains("Successfully registered"));
    }

    private RegisterReaderResponse createNewRegister() {
        RegisterReaderRequest registerReaderRequest = new RegisterReaderRequest();
        registerReaderRequest.setUsername("perrywizzy12345");
        registerReaderRequest.setEmail("perrywizzy12345@gmail.com");
        registerReaderRequest.setPhoneNumber("08065099019");
        registerReaderRequest.setPassword("014704");
        registerReaderRequest.setReaderType(ReaderType.LIBRARIAN);
        RegisterReaderResponse registerReaderResponse = readerService.registerReader(registerReaderRequest);
        return registerReaderResponse;
    }

    @Test
    public void testToRegisterWithSameEmail_ThrowsException(){
        createNewRegister();
        RegisterReaderRequest registerReaderRequest1 = new RegisterReaderRequest();
        registerReaderRequest1.setUsername("perrywizzy12345");
        registerReaderRequest1.setEmail("perrywizzy12345@gmail.com");
        registerReaderRequest1.setPassword("014704");
        registerReaderRequest1.setPhoneNumber("08065099019");
        assertThrows(ReaderAlreadyExistsException.class, ()-> readerService.registerReader(registerReaderRequest1));
    }
    @Test
    public void testToLoginAReader(){
        createNewRegister();
        LoginReaderResponse loginReaderResponse = createNewLogin();
        LoginReaderRequest loginReaderRequest = new LoginReaderRequest();
        loginReaderRequest.setPassword("014704");
        loginReaderRequest.setEmail("perrywizzy12345@gmail.com");
        assertThat(loginReaderResponse).isNotNull();
        assertThat(loginReaderResponse.getMessage().equals("Successfully loggedIn"));
        assertThat(loginReaderResponse.isLoggedIn()).isTrue();
    }

    private LoginReaderResponse createNewLogin() {
        LoginReaderRequest loginReaderRequest = new LoginReaderRequest();
        loginReaderRequest.setEmail("perrywizzy12345@gmail.com");
        loginReaderRequest.setPassword("014704");
        LoginReaderResponse loginReaderResponse = readerService.login(loginReaderRequest);
        return loginReaderResponse;
    }
    @Test
    public void testToLoginWithInvalidCredentials_ThrowsException(){
        createNewRegister();
        createNewLogin();
        LoginReaderRequest loginReaderRequest = new LoginReaderRequest();
        loginReaderRequest.setEmail(loginReaderRequest.getEmail());
        loginReaderRequest.setPassword(loginReaderRequest.getPassword());
        assertThrows (UserNotFoundException.class, ()-> readerService.login(loginReaderRequest));
    }
    @Test
    public void testToAddBook(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("The Great Gatsby");
        addBookRequest.setAuthor("F. Scott Fitzgerald");
        addBookRequest.setIsbn("ISBN-00234-78");
        addBookRequest.setGenre("The Great");
        AddBookResponse addBookResponse = readerService.addBook(addBookRequest);

    }
}