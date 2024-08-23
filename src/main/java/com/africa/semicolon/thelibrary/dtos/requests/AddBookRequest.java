package com.africa.semicolon.thelibrary.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddBookRequest {
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime dateAdded = LocalDateTime.now();
    private String genre;
}
