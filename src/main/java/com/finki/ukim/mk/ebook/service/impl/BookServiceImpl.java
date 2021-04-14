package com.finki.ukim.mk.ebook.service.impl;

import com.finki.ukim.mk.ebook.model.Author;
import com.finki.ukim.mk.ebook.model.Book;
import com.finki.ukim.mk.ebook.model.dto.BookDto;
import com.finki.ukim.mk.ebook.model.enumerations.Category;
import com.finki.ukim.mk.ebook.model.exceptions.AuthorNotFoundException;
import com.finki.ukim.mk.ebook.model.exceptions.BookNotFoundException;
import com.finki.ukim.mk.ebook.repository.AuthorRepository;
import com.finki.ukim.mk.ebook.repository.BookRepository;
import com.finki.ukim.mk.ebook.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);

        Book book = new Book(name,category,author,availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Author author  = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> setAvailableBookCopies(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Integer available = book.getAvailableCopies() - 1;

        if(available >= 0){
            book.setAvailableCopies(available);
            this.bookRepository.save(book);
        }
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
