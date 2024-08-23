package com.africa.semicolon.thelibrary.data.repository;

import com.africa.semicolon.thelibrary.data.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReaderRepository extends MongoRepository<Reader, String> {
    boolean existsByEmail(String email);

    Optional<Reader> findByEmail(String email);
}
