package com.finki.ukim.mk.ebook.service;

import com.finki.ukim.mk.ebook.model.Book;
import com.finki.ukim.mk.ebook.model.dto.BookDto;
import com.finki.ukim.mk.ebook.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findByName(String name);

    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id,String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id,BookDto bookDto);

    Optional<Book> setAvailableBookCopies(Long id);

    void deleteById(Long id);
}
