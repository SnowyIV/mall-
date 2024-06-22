package com.geekaca.web.service.impl;

import com.geekaca.web.dao.BookDao;
import com.geekaca.web.domain.Book;
import com.geekaca.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

@Autowired
private BookDao bookDao;
    @Override
    public int save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int delete(Integer id) {
        return bookDao.delete(id);
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
