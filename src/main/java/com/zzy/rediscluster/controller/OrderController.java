package com.zzy.rediscluster.controller;

import com.zzy.rediscluster.lock.RedisLock;
import com.zzy.rediscluster.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author:zzy
 * @date: 2020/2/11
 * @time: 12:43
 */
@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param productId
     * @return
     */
    @RequestMapping("createOrder")
    public String deductStock(String productId) {
        String result = null;
        try {
            result = orderService.createOrder(Objects.requireNonNull(productId));
            logger.info("下单成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常：" + e);
        }
        return result;
    }
}
