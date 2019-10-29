package com.shop.order.factory;


import java.util.Map;

//订单接口
public interface Order {

    //创建单种类商品订单
    void createOrder(Class cls, Integer value, Double money);

    //创建多种类商品订单
    void createOrder(Map<Class, Integer> map, Double money);

}
