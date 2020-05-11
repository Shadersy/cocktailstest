package com.gvozdilin.libraryJPA.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDto {

    private String name;
    private int yearOfPublishing;
    private List<Long> list = new ArrayList();

    public BookDto() {

    }

    public BookDto(String name) {
        this.name = name;
    }

    public BookDto(String name, int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
        this.name = name;
    }

    public BookDto(String name, int yearOfPublishing, List<Long> authorsId) {
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.list = list;
    }


    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }


}
