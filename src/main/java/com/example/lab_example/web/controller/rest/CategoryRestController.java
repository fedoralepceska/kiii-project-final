package com.example.lab_example.web.controller.rest;

import com.example.lab_example.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://gentle-journey-92804.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoryRestController {
    @GetMapping
    public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
        categories.add(Category.BIOGRAPHY);
        categories.add(Category.CLASSICS);
        categories.add(Category.DRAMA);
        categories.add(Category.HISTORY);
        categories.add(Category.FANTASY);
        categories.add(Category.NOVEL);
        categories.add(Category.THRILER);
        return categories;
    }
}
