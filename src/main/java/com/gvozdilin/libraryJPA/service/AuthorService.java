package com.gvozdilin.libraryJPA.service;

import com.gvozdilin.libraryJPA.dto.AuthorDto;
import com.gvozdilin.libraryJPA.entity.Author;
import com.gvozdilin.libraryJPA.repository.AuthorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorCrudRepository repository;



    public Optional<Author> getAuthorById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Boolean createAuthor(AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getAuthorName());
        author.setSurname(dto.getAuthorSurName());
        author.setPatronymic(dto.getAuthorPatronymic());
        repository.save(author);
        return true;
    }


    @Transactional
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}
