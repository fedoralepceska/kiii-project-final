package com.example.lab_example.model.dto;

import com.example.lab_example.model.enumerations.Category;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Category category;
    Long author;
    Integer copies;

    public BookDto(){}

    public BookDto(String name, Category category, Long author, Integer copies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.copies = copies;
    }
}
