package com.finki.ukim.mk.ebook.repository;

import com.finki.ukim.mk.ebook.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
