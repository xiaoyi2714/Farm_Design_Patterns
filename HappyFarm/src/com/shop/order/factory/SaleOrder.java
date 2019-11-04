package com.shop.order.factory;

import com.shop.order.OrderImpl;


import java.util.HashMap;
import java.util.Map;

//购买订单类
public class SaleOrder implements Order {

    //只卖一类物品的订单
    public void createOrder(Class cls, Integer value, Double earn){
        Map<Class, Integer> map = new HashMap<>();
        map.put(cls, value);
        OrderImpl order = new OrderImpl("SALE", map, earn);
        order.pay();
        if(order.deliverGoods()){
            order.updateSummary();
            System.out.println("Order success");
        }
        else {
            order.refund();
            System.out.println("Order failure");
        }
    }

    //卖大于一类物品的订单
    public void createOrder(Map<Class, Integer> map, Double earn){
        OrderImpl order = new OrderImpl("SALE", map, earn);
        order.pay();
        if(order.deliverGoods()){
            order.updateSummary();
            System.out.println("Order success");
        }
        else {
            order.refund();
            System.out.println("Order failure");
        }
    }

}
