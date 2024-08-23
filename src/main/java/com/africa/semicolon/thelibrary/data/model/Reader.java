package com.africa.semicolon.thelibrary.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Reader {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private boolean isLoggedIn;
    private ReadingFocus readingFocus;
    private ReaderType readerType;
    private List<Book> books;
}
