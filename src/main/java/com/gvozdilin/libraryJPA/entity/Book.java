package com.gvozdilin.libraryJPA.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table(name= "book", schema = "public")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date yearOfPublishing;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    public Book(){

    }

   public Book(String name) {
        this.name = name;
    }

    public Book(String name, Date yearOfPublishing) {
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
    }



    public Date getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Date yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
