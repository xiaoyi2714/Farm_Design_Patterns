package com.shop.repository;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface Repository {
    //为某一类添加库存
    public void add(@NotNull Class cls, @NotNull Integer value);

    //以一个类的字典添加库存
    public void add(@NotNull Map<Class, Integer> map);

    //为某一类请求消耗
    public boolean ask(@NotNull Class cls, @NotNull Integer value);

    //以一个类的字典请求消耗
    public boolean ask(@NotNull Map<Class, Integer> map);

    //查询仓库一项库存的数量
    public Integer checkItemNum(@NotNull Class cls);

    //输出仓库所有库存
    public void showAllItems();

    //
    public Integer getTotalValue();

}
