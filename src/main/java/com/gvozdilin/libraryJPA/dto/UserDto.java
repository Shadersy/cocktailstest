package com.gvozdilin.libraryJPA.dto;

public class UserDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String patronymic;

    public UserDto() {
    }

    public UserDto(String username, String password, String name, String surname, String patronymic) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
