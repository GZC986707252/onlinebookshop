package edu.hut.bookshop.dao;

import edu.hut.bookshop.pojo.Book;

import java.util.List;

/**
 * @Description: 首页书籍展示Dao
 * @Author: guozongchao
 * @Date: 2020/6/4 15:30
 */
public interface BookDisplayMapper {

    /**
     * 根据书名模糊查询
     * @param bookName
     * @return
     */
    List<Book> fuzzyQueryByBookName(String bookName);
}
