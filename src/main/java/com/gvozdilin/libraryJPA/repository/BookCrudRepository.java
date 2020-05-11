package com.gvozdilin.libraryJPA.repository;

import com.gvozdilin.libraryJPA.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BookCrudRepository extends CrudRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findAllByYearOfPublishingLessThanAndYearOfPublishingGreaterThanEqual(int endDate, int startDate);


    @Transactional
    @Query(
            value = "SELECT * FROM book ORDER BY id",
            countQuery = "SELECT count(*) FROM book",
            nativeQuery = true)
    Page<Book> findAllBooksWithPagination(Pageable pageable);
}
