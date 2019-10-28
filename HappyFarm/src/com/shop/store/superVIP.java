package com.shop.store;

public class superVIP implements SaleStrategy {

    //超级会员7折
    public double  doStrategy(Double money) {
        return money * 0.7;
    }

}
