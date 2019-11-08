package com.shop.order.factory;

import java.util.Map;

public class NullOrder implements Order {

    //创建单种类商品订单
    public void createOrder(Class cls, Integer value, Double money){
        System.out.println("Order is not correct!");
    }

    //创建多种类商品订单
    public void createOrder(Map<Class, Integer> map, Double money){
        System.out.println("Order is not correct!");
    }
}
