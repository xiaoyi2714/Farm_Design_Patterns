package com.shop.order.state;

import com.shop.order.OrderImpl;
import org.jetbrains.annotations.NotNull;

//订单状态的接口
public interface OrderStatus {

    // 支付
    void pay(@NotNull OrderImpl order) ;

    // 发货
    void deliverGoods(@NotNull OrderImpl order) ;

}
