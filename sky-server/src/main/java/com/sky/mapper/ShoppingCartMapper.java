package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
 * ClassName: ShoppingCartMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/23 15:32
 * @Version 1.0
 */
@Mapper
public interface ShoppingCartMapper {
    /**
     * 查询购物车列表
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 添加购物车
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);

    /**
     * 修改购物车数量
     * @param shoppingCart
     */
    void updateNumberById(ShoppingCart shoppingCart);
}
