package edu.hut.bookshop.controller;

import com.github.pagehelper.PageInfo;
import edu.hut.bookshop.pojo.Order;
import edu.hut.bookshop.pojo.User;
import edu.hut.bookshop.service.OrderHandleService;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 用户中心模块
 * @Author: guozongchao
 * @Date: 2020/6/2 1:30
 */
@Controller
@RequestMapping("/user_center")
public class UserCenterController {

    @Autowired
    private OrderHandleService orderHandleService;


    /**
     * 根据用户Id获取用户信息，并存放model中，响应视图页面（页面待写）
     * @param userId
     * @return
     */
    @GetMapping("/center/{userId}")
    public String userCenterView(@PathVariable("userId") Integer userId, Model model) {

        return null;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultVO updateUserInfo(@RequestBody @Valid User user) {

        return null;
    }


    /**
     * 根据用户ID,获取用户订单
     * @return
     */
    @GetMapping("/orders")
    @ResponseBody
    public ResultVO getUserOrders(Integer page,Integer limit,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderHandleService.getOrdersByUserId(user.getUserId(), page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS, (int)pageInfo.getTotal(),orders);
    }

}
