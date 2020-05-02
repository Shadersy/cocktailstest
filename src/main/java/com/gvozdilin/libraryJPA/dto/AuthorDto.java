package com.gvozdilin.libraryJPA.dto;

public class AuthorDto {

    public AuthorDto(Long authorId, String authorName, String authorSurName, String authorPatronymic) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorSurName = authorSurName;
        this.authorPatronymic = authorPatronymic;
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

    private Long authorId;
    private String authorName;
    private String authorSurName;
    private String authorPatronymic;


}
