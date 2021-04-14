package com.finki.ukim.mk.ebook.web.rest;

import com.finki.ukim.mk.ebook.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/categories")
public class CategoryRestController {

    @GetMapping
    private Category[] findAll() {
        return Category.values();
    }

}