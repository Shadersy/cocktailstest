package com.gvozdilin.libraryJPA.service;


import com.gvozdilin.libraryJPA.dto.BookDto;
import com.gvozdilin.libraryJPA.entity.Author;
import com.gvozdilin.libraryJPA.entity.Book;
import com.gvozdilin.libraryJPA.entity.User;
import com.gvozdilin.libraryJPA.repository.AuthorCrudRepository;
import com.gvozdilin.libraryJPA.repository.BookCrudRepository;
import com.gvozdilin.libraryJPA.repository.UserCrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {


    @PersistenceContext
    EntityManager entityManager;

    final BookCrudRepository bookCrudRepository;
    final AuthorCrudRepository authorCrudRepository;
    final UserCrudRepository userCrudRepository;

    public BookService(UserCrudRepository userCrudRepository, BookCrudRepository bookCrudRepository, AuthorCrudRepository authorCrudRepository) {
        this.bookCrudRepository = bookCrudRepository;
        this.authorCrudRepository = authorCrudRepository;
        this.userCrudRepository = userCrudRepository;
    }


    @Transactional
    public Book findBookById(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Transactional
    public Boolean save(BookDto dto) {
        List<Author> allAuthors = (List<Author>) authorCrudRepository.findAllById(dto.getList());
        Book book = new Book();
        book.setName(dto.getName());
        book.setYearOfPublishing(dto.getYearOfPublishing());
        book.setAuthors(allAuthors);
        bookCrudRepository.save(book);

        for (Author allAuthor : allAuthors) {
            allAuthor.getBooks().add(book);
        }
        return true;
    }

    @Transactional
    public void deleteBook(Long id) {
        bookCrudRepository.deleteById(id);
    }

    @Transactional
    public List<Book> findAllBook() {
        List<Book> all = (List<Book>) bookCrudRepository.findAll();
        return all;
    }


    @Transactional
    public List<Book> rangeBetweenOfPublication(int endDate, int startDate) {
        List<Book> target = bookCrudRepository.findAllByYearOfPublishingLessThanAndYearOfPublishingGreaterThanEqual(endDate, startDate);
        return target;
    }

    @Transactional
    public void takeBook(Long userId, Long id) {
        Book book = entityManager.find(Book.class, id);
        User user = entityManager.find(User.class, userId);
        entityManager.lock(book, LockModeType.OPTIMISTIC);
        Long qua = user.getQuantity() + 1;
        book.setUserId(userId);
        user.setQuantity(qua);
        bookCrudRepository.save(book);
        userCrudRepository.save(user);
    }

    @Transactional
    public void returnBook(Long userId, Long id) {
        Book book = entityManager.find(Book.class, id);
        User user = entityManager.find(User.class, userId);
        Long qua = user.getQuantity() - 1;
        book.setUserId(null);
        user.setQuantity(qua);
        bookCrudRepository.save(book);
        userCrudRepository.save(user);
    }


    @Transactional
    public List<BookDto> paginationBook(int page, int size, Sort sort) {
        List<BookDto> bookDto = new ArrayList<>();
        Page<Book> books = bookCrudRepository.findAllBooksWithPagination(new PageRequest(page, size, sort));
        List<Book> bookList = books.getContent();


        for (Book s : bookList ) {
            List<Long> authorsId = new ArrayList<>();

            List<Author> authors = s.getAuthors(); // для одной записи
            for (Author k: authors) {
                authorsId.add(k.getId());
            }

            BookDto dto = new BookDto((s.getName()), s.getYearOfPublishing(), authorsId);
            bookDto.add(dto);
        }
        return bookDto;
    }


}
