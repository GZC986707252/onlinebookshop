package edu.hut.bookshop.controller;

import com.github.pagehelper.PageInfo;
import edu.hut.bookshop.pojo.Order;
import edu.hut.bookshop.pojo.User;
import edu.hut.bookshop.service.OrderHandleService;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 订单管理模块
 * @Author: guozongchao
 * @Date: 2020/6/2 1:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderHandleService orderHandleService;

    /**
     * 分页获取订单列表，如果都为空，则获取所有
     * @param page    页码
     * @param limit   每页的条数
     * @return
     */
    @GetMapping("/list")
    public ResultVO getOrderList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
        List<Order> orders = orderHandleService.getAllOrdersByPage(page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS,(int)pageInfo.getTotal(),orders);
    }
    /**
     * 用户提交订单处理
     * @param order
     * @param session
     * @return
     */
    @PostMapping("/submit")
    public ResultVO orderSubmit(@RequestBody Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getUserId());

        orderHandleService.createOrder(order);
        return new ResultVO(ResultCode.SUCCESS,"/user/"+user.getUserName()+"/orders");
    }

    /**
     * 更新订单信息，比如审核通过
     * @param order
     * @return
     */
    @PutMapping("/list/{orderId}")
    public ResultVO updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {

        return null;
    }

    /**
     * 删除指定orderId的订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/list/{orderId}")
    public ResultVO updateOrder(@PathVariable("orderId") Integer orderId) {

        return null;
    }

}
