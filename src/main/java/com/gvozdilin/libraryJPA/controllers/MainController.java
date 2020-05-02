package com.gvozdilin.libraryJPA.controllers;



import com.gvozdilin.libraryJPA.dto.AuthorDto;
import com.gvozdilin.libraryJPA.dto.BookDto;


import com.gvozdilin.libraryJPA.entity.Author;
import com.gvozdilin.libraryJPA.entity.Book;
import com.gvozdilin.libraryJPA.repository.BookCrudRepository;
import com.gvozdilin.libraryJPA.service.AuthorService;
import com.gvozdilin.libraryJPA.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("books")
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    BookCrudRepository bookCrudRepository;


    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;


    @GetMapping("/books")
    Iterable<Book> all() {
        logger.info("логи");
        return bookCrudRepository.findAll();

    }


    @RequestMapping(path="/id", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        logger.info("логи");
        return ResponseEntity.noContent().build();
    }



    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto dto) {
        for (int i = 0; i < dto.getList().size(); i++) {
            Optional<Author> authorById = authorService.getAuthorById(dto.getList().get(i));
            bookService.save(dto, authorById);
            logger.info("логи");
        }

        return ResponseEntity.ok().build();
    }


    @PostMapping(path = "/createAuthor", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto dto) {
        authorService.createAuthor(dto);
        logger.info("логи");

        return ResponseEntity.ok().build();
    }


}