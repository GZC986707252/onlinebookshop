package edu.hut.bookshop.controller;

import com.github.pagehelper.Page;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 用户管理模块控制器
 * @Author: guozongchao
 * @Date: 2020/6/2 2:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 分页获取用户列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public ResultVO getUserList(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {

        return null;
    }

    /**
     * 删除指定用户ID
     * @param userId
     * @return
     */
    @DeleteMapping("/list/{userId}")
    public ResultVO deleteUser(@PathVariable("userId") Integer userId) {

        return null;
    }
}
