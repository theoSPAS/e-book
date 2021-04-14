package com.finki.ukim.mk.ebook.model;

import com.finki.ukim.mk.ebook.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ebooks")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {}

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

}
