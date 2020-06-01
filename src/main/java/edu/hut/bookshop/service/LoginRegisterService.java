package edu.hut.bookshop.service;

import edu.hut.bookshop.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @Description: 登录注册模块业务接口
 * @Author: guozongchao
 * @Date: 2020/6/1 21:49
 */
public interface LoginRegisterService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param session
     */
    void userLogin(String userName, String password, HttpSession session);

    /**
     * 用户注册
     * @param user
     */
    void userRegister(User user);

    /**
     * 管理员登录
     * @param userName
     * @param password
     * @param session
     */
    void adminLogin(String userName, String password, HttpSession session);
}
