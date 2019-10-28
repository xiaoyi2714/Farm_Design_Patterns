package com.shop.order.state;

import com.shop.order.OrderImpl;
import org.jetbrains.annotations.NotNull;

//未支付状态类
public class UnpaidStatus implements OrderStatus{

    public void pay(@NotNull OrderImpl order){
        order.updateMoney();
    }

    public void deliverGoods(@NotNull OrderImpl order){
        System.out.println("不在状态");
    }

}
