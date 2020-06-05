package edu.hut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import edu.hut.bookshop.dao.OrderItemMapper;
import edu.hut.bookshop.dao.OrderMapper;
import edu.hut.bookshop.dao.ShoppingCartMapper;
import edu.hut.bookshop.pojo.Order;
import edu.hut.bookshop.pojo.OrderItem;
import edu.hut.bookshop.service.OrderHandleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 订单处理模块业务实现类
 * @Author: guozongchao
 * @Date: 2020/6/5 1:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderHandleServiceImpl implements OrderHandleService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 创建用户订单
     * @param order
     */
    @Override
    public void createOrder(Order order) {
        //添加父订单
        orderMapper.insert(order);
        //添加订单子项
        for (OrderItem orderItem :order.getOrderItems()) {
            orderItem.setOrderId(order.getOrderId());
            orderItemMapper.insert(orderItem);
            //如果存在购物车，则删除购物车
            shoppingCartMapper.deleteByUserIdAndBookId(order.getUserId(), orderItem.getBookId());
        }
    }

    @Override
    public int deleteOrderById(Integer orderId) {
        orderMapper.deleteByOrderId(orderId);
        return 0;
    }

    /**
     * 查询用户订单
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Order> getOrdersByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectByUserId(userId);
        return orders;
    }

    /**
     * 查询全部订单
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Order> getAllOrdersByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }
}
