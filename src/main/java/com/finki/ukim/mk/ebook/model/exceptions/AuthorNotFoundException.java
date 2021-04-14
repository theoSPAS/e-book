package com.finki.ukim.mk.ebook.model.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long authorId) {
        super(String.format("Author with this %d doesn't exist",authorId));
    }
}
