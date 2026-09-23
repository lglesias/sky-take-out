package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * TODO：
 * ClassName: ShoppingCartService
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 15:30
 * @Version 1.0
 */
public interface ShoppingCartService {
    /**
     * 查询购物车列表
     * @return
     */
    List<ShoppingCart> list();

    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    void add(ShoppingCartDTO shoppingCartDTO);

    /**
     * 清空购物车
     */
    void cleanShoppingCart();
}
