package com.gvozdilin.libraryJPA.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name= "user", schema = "public")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private Long quantity; //количество взятых книг



    public User(){}

    public User(String username, String password, String name, String surname, String patronymic) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Book> books;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


}
