package com.shop.order.factory;

import com.shop.order.OrderImpl;


import java.util.HashMap;
import java.util.Map;

//购买订单类
public class BuyOrder implements Order {

    //只买一类物品的订单
    public void createOrder(Class cls, Integer value, Double cost) {
        Map<Class, Integer> map = new HashMap<>();
        map.put(cls, value);
        OrderImpl order = new OrderImpl("BUY", map, cost);
        order.pay();
        if (order.deliverGoods()) {
            System.out.println("成功下单");
        }
        else {
            order.refund();
            System.out.println("下单失败");
        }
    }

    //买大于一类物品的订单
    public void createOrder(Map<Class, Integer> map, Double cost) {
        OrderImpl order = new OrderImpl("BUY", map, cost);
        order.pay();
        if (order.deliverGoods()) {
            System.out.println("成功下单");
        }
        else {
            order.refund();
            System.out.println("下单失败");
        }
    }
}