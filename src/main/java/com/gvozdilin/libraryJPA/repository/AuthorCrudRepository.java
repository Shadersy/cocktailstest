package com.gvozdilin.libraryJPA.repository;

import com.gvozdilin.libraryJPA.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorCrudRepository extends CrudRepository<Author, Long> {

}
