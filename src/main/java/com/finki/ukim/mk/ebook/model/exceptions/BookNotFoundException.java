package com.finki.ukim.mk.ebook.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with this id %d not found",id));
    }
}
