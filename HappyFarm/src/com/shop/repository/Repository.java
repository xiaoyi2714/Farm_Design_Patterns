package com.shop.repository;



import java.util.Map;

public interface Repository {
    //为某一类添加库存
    public void add(Class cls, Integer value);

    //以一个类的字典添加库存
    public void add(Map<Class, Integer> map);

    //为某一类请求消耗
    public boolean ask(Class cls, Integer value);

    //以一个类的字典请求消耗
    public boolean ask(Map<Class, Integer> map);

    //查询仓库一项库存的数量
    public Integer checkItemNum(Class cls);

    //输出仓库所有库存
    public void showAllItems();

    //
    public Integer getTotalValue();

}
