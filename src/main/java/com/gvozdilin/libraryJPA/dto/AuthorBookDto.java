package com.gvozdilin.libraryJPA.dto;

public class AuthorBookDto {

    public AuthorBookDto(String bookName, String yearOfPublishing, String authorName, String authorSurName, String authorPatronymic) {
        this.bookName = bookName;
        this.yearOfPublishing = yearOfPublishing;
        this.authorName = authorName;
        this.authorSurName = authorSurName;
        this.authorPatronymic = authorPatronymic;
    }

    private Long bookId;
    private String bookName;
    private String yearOfPublishing;

    private Long authorId;
    private String authorName;
    private String authorSurName;
    private String authorPatronymic;


    AuthorBookDto(){

    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public String getAuthorPatronymic() {
        return authorPatronymic;
    }

    public void setAuthorPatronymic(String authorPatronymic) {
        this.authorPatronymic = authorPatronymic;
    }


}
