package com.shop.store;

public interface SaleStrategy {
    //执行优惠策略，算出价格
    public double  doStrategy(Double money);
}
