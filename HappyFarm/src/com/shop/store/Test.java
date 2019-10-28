package com.shop.store;

import com.shop.employee.Egg;
import com.shop.employee.EggCake;
import com.shop.employee.Employee;
import com.shop.order.Corn;
import com.shop.repository.RepositoryProxy;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        SingleStore store = SingleStore.getSingleStore();
        RepositoryProxy.Instance().attach(store);
        RepositoryProxy.Instance().add(Corn.class, 9100);
        //store.update();
        System.out.println(store.getStrategy());
        RepositoryProxy.Instance().add(EggCake.class,100);
        //store.update();
        System.out.println(store.getStrategy());
        RepositoryProxy.Instance().add(Egg.class,100);
        //store.update();
        System.out.println(store.getStrategy());
        Map<Class,Integer> map=new HashMap<>();
        map.put(Egg.class,1000);
        map.put(EggCake.class,1000);
        Employee.createBuyOrder(map);

    }
}
