package com.example.lab_example.repository;

import com.example.lab_example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    void deleteBookByName(String name);
}
