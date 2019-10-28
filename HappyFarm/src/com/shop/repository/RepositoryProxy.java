package com.shop.repository;

import com.shop.store.SingleStore;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepositoryProxy implements Repository {
    private static RepositoryProxy repositoryProxy = new RepositoryProxy();

    public static RepositoryProxy Instance(){
        return repositoryProxy;
    }

    private List<SingleStore> observers = new ArrayList<>();

    private RepositoryImpl repository = new RepositoryImpl();

    private void notifyAllObservers(){
        for (SingleStore observer : observers){
            observer.update();
        }
    }

    public void attach(SingleStore singleStore){
        this.observers.add(singleStore);
    }

    public void add(@NotNull Class cls, @NotNull Integer value){
        repository.add(cls, value);
        notifyAllObservers();
    }

    //以一个类的字典添加库存
    public void add(@NotNull Map<Class, Integer> map){
        repository.add(map);
        notifyAllObservers();
    }

    //为某一类请求消耗
    public boolean ask(@NotNull Class cls, @NotNull Integer value){
        boolean result = repository.ask(cls, value);
        if (result){
            notifyAllObservers();
        }
        return result;
    }

    //以一个类的字典请求消耗
    public boolean ask(@NotNull Map<Class, Integer> map){
        boolean result = repository.ask(map);
        if (result){
            notifyAllObservers();
        }
        return result;
    }

    //查询仓库一项库存的数量
    public Integer checkItemNum(@NotNull Class cls){
        return repository.checkItemNum(cls);
    }

    //输出仓库所有库存
    public void showAllItems(){
        repository.showAllItems();
    }

    public Integer getTotalValue(){
        return repository.getTotalValue();
    }



}


