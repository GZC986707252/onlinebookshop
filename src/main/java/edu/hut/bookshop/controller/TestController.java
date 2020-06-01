package edu.hut.bookshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hut.bookshop.dao.BookMapper;
import edu.hut.bookshop.exception.CustomizeException;
import edu.hut.bookshop.pojo.Book;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 测试
 * @Author: guozongchao
 * @Date: 2020/6/1 23:33
 */
@RestController
public class TestController {

    @Resource
    private BookMapper bookMapper;

    @GetMapping("/test")
    public ResultVO test() {
        PageHelper.startPage(1,5);
        List<Book> books = bookMapper.selectAllByCategoryCode("wenyi");
        PageInfo pageInfo=new PageInfo(books);
        Map<String, Object> data = new HashMap<>();
        data.put("books",books);
        data.put("pageinfo", pageInfo);
        return new ResultVO(ResultCode.SUCCESS, data);
    }

    @GetMapping("/test1")
    public ResultVO test1() {
        List<Book> books = bookMapper.selectAllByCategoryCode(null);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    @GetMapping("/test2")
    public ResultVO test2() {
        List<Book> books = bookMapper.selectAllByCategoryCode(null);
        throw new CustomizeException(ResultCode.RECORD_NOT_FOUND);
    }
}
