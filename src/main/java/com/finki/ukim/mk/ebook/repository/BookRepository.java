package com.finki.ukim.mk.ebook.repository;

import com.finki.ukim.mk.ebook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByName(String name);

    void deleteByName(String name);
}
