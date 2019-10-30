package com.shop.order.state;

import com.shop.order.OrderImpl;


//未支付状态类
public class UnpaidStatus implements OrderStatus{

    public void pay(OrderImpl order){
        order.updateMoney();
    }

    public void deliverGoods(OrderImpl order){
        System.out.println("不在状态");
    }

}
