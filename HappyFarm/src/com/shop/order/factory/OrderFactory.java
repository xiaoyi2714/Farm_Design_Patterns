package com.shop.order.factory;

import org.jetbrains.annotations.NotNull;

//订单工厂
public class OrderFactory {

    //使用getOrder方法获取订单类型的对象
    public Order getOrder(@NotNull String orderType){
        switch (orderType){
            case "BUY":
                return new BuyOrder();
            case "SALE":
                return new SaleOrder();
            default:
                return null;
        }
    }

}

/*

    使用方法
    OrderFactory orderFactory = new OrderFactory();

    获取 BuyOrder 的对象，并调用它的 createOrder 方法
    Order order = orderFactory.getOrder("BUY");

    调用 Order 的 createOrder 方法
    order.createOrder(两种参数都行);

 */
