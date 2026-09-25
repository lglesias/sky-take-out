package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO：
 * ClassName: OrderMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/25 14:11
 * @Version 1.0
 */
@Mapper
public interface OrderMapper {
    /**
     * 用户下单
     * @param orders
     */
    void insert(Orders orders);
}
