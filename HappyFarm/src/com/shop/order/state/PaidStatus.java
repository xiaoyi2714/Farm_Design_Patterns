package com.shop.order.state;

import com.shop.order.OrderImpl;


//已支付状态类
public class PaidStatus implements OrderStatus{

    public void pay(OrderImpl order){
        System.out.println("请勿重复支付");
    }

    public void deliverGoods(OrderImpl order){
        order.updateInventory();
    }

}
