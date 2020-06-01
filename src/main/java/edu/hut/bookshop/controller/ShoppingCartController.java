package edu.hut.bookshop.controller;

import edu.hut.bookshop.pojo.ShoppingCart;
import edu.hut.bookshop.util.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description: 购物城模块控制器
 * @Author: guozongchao
 * @Date: 2020/6/2 0:43
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    /**
     * 根据用户ID获取该用户的购物车
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResultVO getCartByUserId(@RequestParam(required = true) Integer userId) {

        return null;
    }

    /**
     * 更新购物车的商品数量
     * @param cartId  购物车Id
     * @param quantity  商品购买数量
     * @return
     */
    @PutMapping("/list/{cartId}")
    public ResultVO updateCartItem(@PathVariable("cartId") Integer cartId,Integer quantity) {

        return null;
    }

    /**
     * 添加到购物车请求处理
     * @param cart  接收前台传来的参数
     * @return
     */
    @PostMapping("/list")
    public ResultVO addToShoppingCart(ShoppingCart cart) {

        return null;
    }

    /**
     * 删除前台传来的cartId的购物车项
     * @param cartId
     * @return
     */
    @DeleteMapping("/list/{cartId}")
    public ResultVO deleteCartItem(@PathVariable("cartId") Integer cartId) {

        return null;
    }
}
