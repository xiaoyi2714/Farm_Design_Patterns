package com.shop.order.singleton;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrderSummary {

    private Map<String, Integer> saleList = new HashMap<>();

    private static OrderSummary summary = new OrderSummary();

    private OrderSummary(){}

    public static OrderSummary getSummary(){
        return summary;
    }

    public void add(@NotNull Class cls, @NotNull Integer value){
        String type = cls.getSimpleName();
        if (!saleList.containsKey(type)){
            saleList.put(type, value);
        }else{
            saleList.put(type, value + saleList.get(type));
        }

    }

    public void add(@NotNull Map<Class, Integer> map){
        for (Map.Entry<Class, Integer> entry : map.entrySet()){
            this.add(entry.getKey(), entry.getValue());
        }

    }

    public void showAllItems(){
        Iterator<Map.Entry<String, Integer>> iterator = saleList.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.printf("销售报告中%s项的销售量为%d", entry.getKey(), entry.getValue());
        }
    }
}
