package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * TODO：
 * ClassName: Orderservice
 * Package: com.sky.service
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/25 14:10
 * @Version 1.0
 */
public interface Orderservice {
    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
