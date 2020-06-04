package edu.hut.bookshop.controller;

import edu.hut.bookshop.dao.UserMapper;
import edu.hut.bookshop.pojo.Book;
import edu.hut.bookshop.pojo.User;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Description: 登录注册模块的控制器
 * @Author: guozongchao
 * @Date: 2020/6/1 21:54
 */

@RestController
public class LoginRegisterController {
    /**
     * 用户登录请求处理
     * @param userName
     * @param Password
     * @return
     */
    @PostMapping("/user/login")
    public ResultVO userLoginHandler(String userName, String Password) {
    	
        return null;   
    }
    /**
     * 用户注册请求处理
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public ResultVO userRegisterHandler(User user) {

        return null;
    }

    /**
     * 管理员登录请求处理
     * @param adminName
     * @param password
     * @return
     */
    @PostMapping("/admin/login")
    public ResultVO adminLoginHandler(String adminName, String password) {

        return null;
    }
}
