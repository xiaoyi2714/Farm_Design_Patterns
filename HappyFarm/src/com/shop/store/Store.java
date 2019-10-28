package com.shop.store;

import org.jetbrains.annotations.NotNull;

public interface Store {
    //订单通过update来更新profit
    public void updateProfit(@NotNull Double money, @NotNull String op);

    public Double useStrategy(@NotNull Double initialPrice);
}
