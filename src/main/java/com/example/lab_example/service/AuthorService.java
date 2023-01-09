package com.example.lab_example.service;

import com.example.lab_example.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();
    Optional<Author> findById(Long id);
    Optional<Author> create (String name,String surname, Long country);
}
