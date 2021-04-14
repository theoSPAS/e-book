package com.finki.ukim.mk.ebook.model.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long countryId) {
        super(String.format("Country not found with this id %d",countryId));
    }
}
