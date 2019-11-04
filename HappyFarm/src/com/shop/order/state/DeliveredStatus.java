package com.shop.order.state;

import com.shop.order.OrderImpl;


//已更新库存状态类
public class DeliveredStatus implements OrderStatus {

    //支付
    public void pay(OrderImpl order){
        System.out.println("Please do not pay repeatedly");
    }

    //更新库存
    public void deliverGoods(OrderImpl order){
        System.out.println("State error");
    }
}
