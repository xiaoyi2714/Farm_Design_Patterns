package com.shop.store;



public interface Store {
    //订单通过update来更新profit
    public void updateProfit(Double money, String op);
    //输入初始金额计算使用优惠策略后的金额
    public Double useStrategy(Double initialPrice);
}
