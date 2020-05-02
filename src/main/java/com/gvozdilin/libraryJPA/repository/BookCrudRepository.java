package com.gvozdilin.libraryJPA.repository;

import com.gvozdilin.libraryJPA.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCrudRepository extends CrudRepository<Book, Long> {


//    @Modifying
//    @Query("update book t set t.name = :name, t.year_of_publishing= where t.id = :id")
//    int setValue(@Param("id") Long id, @Param("value") String value);
}
