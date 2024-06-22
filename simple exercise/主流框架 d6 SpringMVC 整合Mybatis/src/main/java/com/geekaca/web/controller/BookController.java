package com.geekaca.web.controller;


import com.geekaca.web.constants.BookConstant;
import com.geekaca.web.domain.Book;
import com.geekaca.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        int saved = bookService.save(book);
        Result result = new Result();
        if (saved > 0) {
            result.setCode(BookConstant.SAVE_OK);
            result.setMsg("保存成功");
        } else {
            result.setCode(BookConstant.SAVE_ERR);
            result.setMsg("保存失败");
        }
        return result;
    }

    @GetMapping
    public Result  getAllBooks(){
        Result result = new Result();
        List<Book> bookList = bookService.getAll();
        if (bookList != null && bookList.size() > 0) {
            result.setCode(BookConstant.GET_OK);
            result.setData(bookList);
        } else {
            result.setCode(BookConstant.GET_ERR);
            result.setMsg("没有查询到数据");
        }
        return result;
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Book book) {
        int updated = bookService.update(book);
        return updated > 0;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book == null ? BookConstant.GET_ERR : BookConstant.GET_OK;
        String msg = book == null ? "查询失败" : "查询成功";

        Result result = new Result(code, msg, book);
        return result;
    }
}
