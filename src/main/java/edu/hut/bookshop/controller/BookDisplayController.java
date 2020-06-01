package edu.hut.bookshop.controller;

import edu.hut.bookshop.util.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 首页商品展示模块控制器
 * @Author: guozongchao
 * @Date: 2020/6/2 0:22
 */
@Controller
@RequestMapping("/home")
public class BookDisplayController {

    /**
     * 处理前台获取所有分类的请求
     * @return
     */
    @GetMapping("/category")
    @ResponseBody
    public ResultVO getCategories() {

        return null;
    }

    /**
     * 根据前台传来的categoryCode，响应对应的分类的书籍
     * 需要进行分页响应
     * 如果categoryCode为null,则响应所有书籍
     * @param categoryCode   分类代码
     * @param page           页码
     * @param limit          每页的数量
     * @return
     */
    @GetMapping("/books")
    @ResponseBody
    public ResultVO getBooksByCategoryCode(@RequestParam(required = false) String categoryCode, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {

        return null;
    }

    /**
     * 根据请求的bookId,返回该Id的书籍信息，响应Html视图（前端页面待写）
     * @param bookId
     * @return
     */
    @GetMapping("/books/{bookId}")
    public String bookDetailsView(@PathVariable("bookId") Integer bookId) {

        return null;
    }

    /**
     * 首页搜索书籍
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    @ResponseBody
    public ResultVO searchBook(String keyword) {
        return null;
    }
}
