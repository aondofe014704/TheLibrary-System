package com.africa.semicolon.thelibrary.data.repository;

import com.africa.semicolon.thelibrary.data.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
