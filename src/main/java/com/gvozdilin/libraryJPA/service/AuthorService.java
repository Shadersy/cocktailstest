package com.gvozdilin.libraryJPA.service;

import com.gvozdilin.libraryJPA.dto.AuthorDto;
import com.gvozdilin.libraryJPA.entity.Author;
import com.gvozdilin.libraryJPA.repository.AuthorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorCrudRepository repository;

    public Optional<Author> getAuthorById(Long id) {

        Optional<Author> author = repository.findById(id);
        return author;
    }


    public Boolean createAuthor(AuthorDto dto) {

        Author v = new Author(dto.getAuthorName(),
                dto.getAuthorSurName(), dto.getAuthorPatronymic());
        repository.save(v);
        return true;
    }
}
