package com.finki.ukim.mk.ebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ebooks")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country() {}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
