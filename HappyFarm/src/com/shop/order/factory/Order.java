package com.shop.order.factory;

import org.jetbrains.annotations.NotNull;
import java.util.Map;

//订单接口
public interface Order {

    //创建单种类商品订单
    void createOrder(@NotNull Class cls, @NotNull Integer value, @NotNull Double money);

    //创建多种类商品订单
    void createOrder(@NotNull Map<Class, Integer> map, @NotNull Double money);

}
