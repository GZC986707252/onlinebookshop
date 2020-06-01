package edu.hut.bookshop.controller;

import edu.hut.bookshop.pojo.Order;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 订单管理模块
 * @Author: guozongchao
 * @Date: 2020/6/2 1:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 分页获取订单列表，如果都为空，则获取所有
     * @param page    页码
     * @param limit   每页的条数
     * @return
     */
    @GetMapping("/list")
    public ResultVO getOrderList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
        return null;
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @PostMapping("/list")
    public ResultVO addOrder(@RequestBody Order order){

        return null;
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
