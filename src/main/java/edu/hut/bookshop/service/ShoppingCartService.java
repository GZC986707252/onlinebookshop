package edu.hut.bookshop.service;

import edu.hut.bookshop.pojo.ShoppingCart;

import java.util.List;

/**
 * @Description: 购物车模块业务接口
 * @Author: guozongchao
 * @Date: 2020/6/4 19:22
 */

public interface ShoppingCartService {

    int addToShoppingCart(ShoppingCart cart);

    int deleteShoppingCarts(int[] cartIds);

    int deleteShoppingCartByCartId(Integer cartId);

    int updateShoppingCart(ShoppingCart cart);

    List<ShoppingCart> getShoppingCartsByUserId(Integer userId);
}
