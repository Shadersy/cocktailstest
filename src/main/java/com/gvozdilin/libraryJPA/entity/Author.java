package com.gvozdilin.libraryJPA.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name= "author", schema = "public")
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;

    public Author() {}


    public Author(Long id) {
        this.id=id;
    }

    public Author(Long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Author( String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })

    @JoinTable(name = "authorBook",
            joinColumns = { @JoinColumn(name = "authorId",
            referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "bookId",
            referencedColumnName = "id") })

    private List<Book> books = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
