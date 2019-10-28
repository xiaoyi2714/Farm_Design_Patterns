package com.shop.store;
public class goldVIP implements SaleStrategy{

    //黄金会员八折
    public double  doStrategy(Double money) {
        return money * 0.8;
    }

}
