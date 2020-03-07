package com.zzy.rediscluster.controller;

import com.zzy.rediscluster.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Page com.zzy.rediscluster.controller
 * @Author Sevon
 * @Date 2020/3/7 20:59
 * @Version 1.0
 */
@RestController
class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param productId
     * @return
     */
    @RequestMapping("createOrder")
    public String deductStock(String productId) {
        String result = null;
        try {
            result = orderService.createOrder(Objects.requireNonNull(productId));

            if (!"SUCCESS".equals(result)) {
                logger.info("下单失败！！！");
                return "库存不足！！";
            }
            logger.info("下单成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常：" + e);
        }
        return result;
    }
}
