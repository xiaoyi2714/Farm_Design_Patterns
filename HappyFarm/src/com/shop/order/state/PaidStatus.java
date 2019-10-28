package com.shop.order.state;

import com.shop.order.OrderImpl;
import org.jetbrains.annotations.NotNull;

//已支付状态类
public class PaidStatus implements OrderStatus{

    public void pay(@NotNull OrderImpl order){
        System.out.println("请勿重复支付");
    }

    public void deliverGoods(@NotNull OrderImpl order){
        order.updateInventory();
    }

}
