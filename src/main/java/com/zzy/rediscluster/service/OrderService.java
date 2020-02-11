package com.zzy.rediscluster.service;

/**
 * @author:zzy
 * @date: 2020/2/11
 * @time: 16:51
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
