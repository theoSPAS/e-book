package com.finki.ukim.mk.ebook.service;

import com.finki.ukim.mk.ebook.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long countryId);

    void deleteById(Long id);
}
