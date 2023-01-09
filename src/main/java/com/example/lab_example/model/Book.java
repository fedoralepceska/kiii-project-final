package com.example.lab_example.model;

import com.example.lab_example.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    Integer copies;

    public Book(){}

    public Book(String name, Category category, Author author, Integer copies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.copies = copies;
    }
}
