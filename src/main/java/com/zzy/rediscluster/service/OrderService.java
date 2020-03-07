package com.zzy.rediscluster.service;


/**
 * @Page com.zzy.rediscluster.service
 * @Author Sevon
 * @Date 2020/3/7 20:59
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param productId
     * @return
     */
    public String createOrder(String productId);
}
