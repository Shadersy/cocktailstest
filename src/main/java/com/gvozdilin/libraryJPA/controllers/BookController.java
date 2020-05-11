package com.gvozdilin.libraryJPA.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.gvozdilin.libraryJPA.dto.BookDto;
import com.gvozdilin.libraryJPA.entity.Book;
import com.gvozdilin.libraryJPA.repository.BookCrudRepository;
import com.gvozdilin.libraryJPA.service.BookService;
import com.gvozdilin.libraryJPA.specification.BookSpecificationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("bookss")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    final BookService bookService;


    public BookController(BookService bookService, BookCrudRepository bookCrudRepository) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    ResponseEntity<List<Book>> all() {
        List<Book> all = bookService.findAllBook();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/range")  //получить список всех книг, где год их издания между endDate и startDate
    ResponseEntity<List<Book>> getRangedBooks(int endDate, int startDate) {
        List<Book> ranged = bookService.rangeBetweenOfPublication(endDate, startDate);
        return ResponseEntity.ok().body(ranged);
    }

    @DeleteMapping(path = "/id/{id}") //удалить книгу по id
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> createBook(@RequestBody BookDto dto) { //создать книгу, зная id автора(ов)
        bookService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "takeBook/{id}/{userId}") //взять книгу
    public ResponseEntity<Void> takeBook(@PathVariable Long id, @PathVariable Long userId) {
        logger.info(id + " " + userId);
        bookService.takeBook(userId, id);
        return ResponseEntity.ok().build();
    }


    @PutMapping(path = "returnBook/{id}/{userId}") //вернуть книгу
    public ResponseEntity<Void> returnBook(@PathVariable Long id, @PathVariable Long userId) {
        logger.info(id + " " + userId);
        bookService.returnBook(userId, id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(path = "getPagination/{page}/{size}/{sort}") //вернуть отображение списка книг в виде пагинации
    public List<BookDto> getPagination(int page, int size, Sort sort) {
        List<BookDto> dto = bookService.paginationBook(page, size, sort);
        return dto;
    }

}