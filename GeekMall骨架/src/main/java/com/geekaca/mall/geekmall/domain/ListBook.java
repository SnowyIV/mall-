package com.geekaca.mall.geekmall.domain;

import java.util.ArrayList;
import java.util.List;

public class ListBook {
    private List<Book> books;

    public ListBook() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
