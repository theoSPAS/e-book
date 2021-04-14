package com.finki.ukim.mk.ebook.web.rest;

import com.finki.ukim.mk.ebook.model.Author;
import com.finki.ukim.mk.ebook.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private  final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<Author> findAll(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    //String name, String surname, Long countryId
    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam Long countryId){
        return this.authorService.save(name,surname,countryId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() ->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.authorService.deleteById(id);

        if(this.authorService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
