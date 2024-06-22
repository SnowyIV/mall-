package com.geekaca.web.service;

import com.geekaca.web.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    public int save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public int update(Book book);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Book> getAll();
}
