package com.shop.store;

public class normalVIP implements SaleStrategy {
    //普通会员九折
    public double  doStrategy(Double money) {
        return money * 0.9;
    }

}
