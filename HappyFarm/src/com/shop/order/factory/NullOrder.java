package com.shop.order.factory;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class NullOrder implements Order {

    //创建单种类商品订单
    public void createOrder(@NotNull Class cls, @NotNull Integer value, @NotNull Double money){
        System.out.println("Order is not correct!");
    }

    //创建多种类商品订单
    public void createOrder(@NotNull Map<Class, Integer> map, @NotNull Double money){
        System.out.println("Order is not correct!");
    }
}
