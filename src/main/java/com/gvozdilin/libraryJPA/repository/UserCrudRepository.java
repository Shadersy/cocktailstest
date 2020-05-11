package com.gvozdilin.libraryJPA.repository;

import com.gvozdilin.libraryJPA.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
}
