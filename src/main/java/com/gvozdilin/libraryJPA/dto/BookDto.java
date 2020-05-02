package com.gvozdilin.libraryJPA.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookDto {

    private String name;
    private Date yearOfPublishing;
    private List<Long> list = new ArrayList();

    public BookDto(){

    }


    public BookDto(String name, Date yearOfPublishing, List<Long> list)
    {
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.list=list;
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

    public Date getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Date yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }



}
