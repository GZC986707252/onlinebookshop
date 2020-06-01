package edu.hut.bookshop.service.impl;

import edu.hut.bookshop.pojo.User;
import edu.hut.bookshop.service.LoginRegisterService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Description: 登录注册模块实现类
 * @Author: guozongchao
 * @Date: 2020/6/1 21:50
 */
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {
    @Override
    public void userLogin(String userName, String password, HttpSession session) {

    }

    @Override
    public void userRegister(User user) {

    }

    @Override
    public void adminLogin(String userName, String password, HttpSession session) {

    }
}
