package com.shop.store;

public class ExecuteStrategy {
    //执行策略，计算最终金额
    public static Double CalculatePrice(SaleStrategy strategy,Double price){
        return strategy.doStrategy(price);
    }
}
