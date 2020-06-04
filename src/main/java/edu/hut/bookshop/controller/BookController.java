package edu.hut.bookshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.SafeHtml.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.hut.bookshop.dao.BookMapper;
import edu.hut.bookshop.pojo.Book;
import edu.hut.bookshop.service.BookService;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;

/**
 * @Description: 书籍管理模块控制器
 * @Author: guozongchao
 * @Date: 2020/6/2 2:03
 */
 @RestController
 @RequestMapping("/book")
 public class BookController {
  @Resource
  private BookMapper bookMapper;
  @Autowired
  private BookService bookService;
  
  
  @GetMapping("/searchid")
  public ResultVO bookSearchByBookId(Integer bookId) {
	 // Book books=bookMapper.selectByBookId(bookIde);
	  Book books = bookService.bookSearchById(bookId);
	  if(books!=null)
	  return new ResultVO(ResultCode.SUCCESS,books);  
	  else
	  return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);  
  }
  @PostMapping("/delete")
  public ResultVO bookDelete(Integer bookId) {
	  int books=bookService.bookDeleteSearchById(bookId);
	  return new ResultVO(ResultCode.SUCCESS, null);
  }

  @PostMapping("/insert")
  public ResultVO bookInsert(Book record) {
	  int books=bookService.bookInsert(record);
	  return new ResultVO(ResultCode.SUCCESS, null);
  }
  @GetMapping("/searchcode")
  public ResultVO bookSerchByCategoryCode(String catrgoryCode) {
      PageHelper.startPage(1,5);
      List<Book> books = bookService.bookSearchByCode(catrgoryCode);
     if(books.size()!=0)
     {
    	      PageInfo pageInfo=new PageInfo(books);
      Map<String, Object> data = new HashMap<>();
      data.put("books",books);
      data.put("pageinfo", pageInfo);
      return new ResultVO(ResultCode.SUCCESS, books);
     }
     else
    	 return new ResultVO(ResultCode.RECORD_NOT_FOUND, null);
      
    
      
  }
    @PostMapping("/update")
    public ResultVO bookUpdate(Book record) {
	  int books=bookService.bookUpdate(record);
	  return new ResultVO(ResultCode.SUCCESS, null);
  }
  
		
	
	
	
	
	
	
	
}
