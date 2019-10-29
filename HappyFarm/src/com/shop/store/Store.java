package com.shop.store;



public interface Store {
    //订单通过update来更新profit
    public void updateProfit(Double money, String op);

    public Double useStrategy(Double initialPrice);
}
