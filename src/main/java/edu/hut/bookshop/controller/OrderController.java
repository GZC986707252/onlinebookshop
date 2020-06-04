package edu.hut.bookshop.controller;

import edu.hut.bookshop.pojo.Order;
import edu.hut.bookshop.pojo.OrderItem;
import edu.hut.bookshop.pojo.User;

import edu.hut.bookshop.service.OrderService;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Description: 订单管理模块
 * @Author: guozongchao
 * @Date: 2020/6/2 1:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {
     @Autowired
     private OrderService orderService;

    /**
     * 分页获取订单列表，如果都为空，则获取所有
     * @param page    页码
     * @param limit   每页的条数
     * @return
     */
    @GetMapping("/list")
    public ResultVO getOrderList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
    	PageHelper.startPage(page,limit);
    	List<Order> orders = orderService.selectAll();
        PageInfo pageInfo=new PageInfo(orders);
        Map<String, Object> data = new HashMap<>();
        data.put("orders",orders);
        data.put("pageinfo", pageInfo);
    	return new ResultVO(ResultCode.SUCCESS,data);  
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
    @PutMapping("/list/update/{orderId}")
   
    public ResultVO updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {
           Order orders1 = orderService.selectByOrderId(orderId);
           if(orders1!=null)
           {
        	order.setOrderId(orderId);
        	int orders = orderService.updateByOrderId(order);
        	return new ResultVO(ResultCode.SUCCESS,null);  
           }
           else 
        	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null); 
    }

    /**
     * 删除指定orderId的订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/list/{orderId}")
    public ResultVO deleteOrder(@PathVariable("orderId") Integer orderId) {
    	int orders = orderService.deleteByOrderId(orderId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }
    
    @GetMapping("/list/{userId}")
    public ResultVO getOrderByUserId(@PathVariable("userId") Integer userId) {
    	
    	List<Order> orders = orderService.selectByUserId(userId);
    	if(orders.size()!=0)
    	{
    		 
    		return new ResultVO(ResultCode.SUCCESS,orders);
    	}
    	
        else
        	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
    }
    @GetMapping("/list/orders/{orderId}")
        public ResultVO getOrderByOrderId(@PathVariable("orderId") Integer orderId) {
    	Order orders = orderService.selectByOrderId(orderId);
    	if(orders!=null)
        return new ResultVO(ResultCode.SUCCESS,orders);
    	else
    	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null); 
    }

    
    
     
}
