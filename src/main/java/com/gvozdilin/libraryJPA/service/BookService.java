package com.gvozdilin.libraryJPA.service;


import com.gvozdilin.libraryJPA.dto.BookDto;
import com.gvozdilin.libraryJPA.entity.Author;
import com.gvozdilin.libraryJPA.entity.Book;
import com.gvozdilin.libraryJPA.repository.BookCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {

    @Autowired
    BookCrudRepository bookCrudRepository;

    public Boolean save(BookDto dto, Optional<Author> author) {

        if (author.isPresent()) {
            Book v = new Book(dto.getName(), dto.getYearOfPublishing());
            v.getAuthors().add(author.get());
            bookCrudRepository.save(v);
        }
        return true;
    }

    public void deleteBook(Long id) {
        bookCrudRepository.deleteById(id);
    }

}
