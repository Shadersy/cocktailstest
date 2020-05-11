package com.gvozdilin.libraryJPA.controllers;

import com.gvozdilin.libraryJPA.dto.AuthorDto;
import com.gvozdilin.libraryJPA.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class MainController { //Контроллер автора
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final AuthorService authorService;

    public MainController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/createAuthor", consumes = MediaType.APPLICATION_JSON_VALUE, //создать автора
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> createAuthor(@RequestBody AuthorDto dto) {
        authorService.createAuthor(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) { //удалить автора
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}