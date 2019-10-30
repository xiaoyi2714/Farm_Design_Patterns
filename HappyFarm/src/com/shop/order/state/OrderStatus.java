package com.shop.order.state;

import com.shop.order.OrderImpl;


//订单状态的接口
public interface OrderStatus {

    // 支付
    void pay(OrderImpl order) ;

    // 发货
    void deliverGoods(OrderImpl order) ;

}
