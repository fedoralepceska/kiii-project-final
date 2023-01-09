package com.example.lab_example.service;

import com.example.lab_example.model.Book;
import com.example.lab_example.model.dto.BookDto;
import com.example.lab_example.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> findById(Long id);
    Optional<Book> create(BookDto book);
    Optional<Book> edit(Long id,BookDto book);
    Optional<Book> create(String name, Category category,Long author, Integer copies);
    Optional<Book> edit(Long id, String name, Category category,Long author, Integer copies);
    void deleteById(Long id);
    Book MarkAsTaken (Long id);
}
