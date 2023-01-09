package com.example.lab_example.service;

import com.example.lab_example.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country> findById(Long id);
    Optional<Country> create(String name,String continent);
}
