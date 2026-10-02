package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务类
 * ClassName: OrderTask
 * Package: com.sky.task
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/10/2 17:41
 * @Version 1.0
 */
@Component
@Slf4j
public class OrderTask {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 处理超时订单
     */
    @Scheduled(cron = "0 * * * * ?")
    public void processTimeOutOrder() {

        log.info("处理超时订单...,{}", LocalDateTime.now());

        //select * from orders where status = ? and order_time <(当前时间 - 15分钟)
        List<Orders> orderList = orderMapper.getByStatusAndOrdersTimeLT(Orders.PENDING_PAYMENT, LocalDateTime.now().plusMinutes(-15));

        if (orderList != null && orderList.size() > 0) {
            for (Orders orders : orderList) {
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("订单超时未支付，系统自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);
                log.info("订单超时：{}", orders.getId());
            }
        }
    }


    /**
     * 处理待派送订单
     */
    @Scheduled(cron = "0 0 1 * * ?") //每天凌晨一点触发一次
    public void processDeliveryOrder() {
        log.info("处理待派送订单...{}", LocalDateTime.now());
        List<Orders> orderList = orderMapper.getByStatusAndOrdersTimeLT(Orders.DELIVERY_IN_PROGRESS, LocalDateTime.now().plusMinutes(-60));
        if (orderList != null && orderList.size() > 0) {
            for (Orders orders : orderList) {
                orders.setStatus(Orders.COMPLETED);
                orders.setCancelReason("订单超时未支付，系统自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);
                log.info("订单超时：{}", orders.getId());
            }
        }
    }
}
