package com.finki.ukim.mk.ebook.service.impl;

import com.finki.ukim.mk.ebook.model.Author;
import com.finki.ukim.mk.ebook.model.Country;
import com.finki.ukim.mk.ebook.model.exceptions.CountryNotFoundException;
import com.finki.ukim.mk.ebook.repository.AuthorRepository;
import com.finki.ukim.mk.ebook.repository.CountryRepository;
import com.finki.ukim.mk.ebook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));

        Author author = new Author(name,surname,country);

        return Optional.of(this.authorRepository.save(author));

    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
