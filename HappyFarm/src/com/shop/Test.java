package com.shop;


import com.shop.employee.*;
import com.shop.store.*;
import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;
import com.shop.order.singleton.OrderSummary;
import com.shop.repository.RepositoryProxy;


public class Test {
    public static void main(String[] args) {
        //单例模式
        System.out.println("---------- Test SingleStore Singleton ----------");
        SingleStore store = SingleStore.getSingleStore();
        System.out.println("You have got a SingleStore!");
        //策略模式，观察者模式
        System.out.println("---------- Test SingleStore strategy and observer ----------");
        RepositoryProxy.Instance().attach(store);
        System.out.println("The repository has attached the SingleStore!");
        RepositoryProxy.Instance().add(Egg.class, 9100);
        System.out.println("The SingleStore has sold 1000 Eggs,whose initial price is " + new Egg().getprice() * 1000);
//        System.out.println("The strategy is normalVIP, whose discount is " + store.getStrategy());
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 1000));
        Employee.createSaleOrder(Egg.class,1000);

        System.out.println("The SingleStore has sold 4000 Eggs,whose price is " + new Egg().getprice() * 4000);
//        System.out.println("The strategy is goldVIP, whose discount is " + store.getStrategy());
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 4000));
        Employee.createSaleOrder(Egg.class,4000);

        System.out.println("The SingleStore has sold 3000 Eggs,whose price is " + new Egg().getprice());
//        System.out.println("The strategy is superVIP, whose discount is " + store.getStrategy());
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 1000));
        Employee.createSaleOrder(Egg.class,1000);

        System.out.println("---------- Test RespositoryProxy Singleton ----------");
        System.out.println("Firstly get RepositoryProxy Instance.");
        RepositoryProxy.Instance();
        System.out.println("Secondly get RepositoryProxy Instance.");
        RepositoryProxy.Instance();

        System.out.println("---------- Test RepositoryProxy Proxy ----------");
        System.out.println("Test: Add Corn 100.");
        RepositoryProxy.Instance().add(Corn.class, 100);
        System.out.println("Test: Ask to consume Corn 150.");
        RepositoryProxy.Instance().ask(Corn.class, 150);
        System.out.println("Test: Ask to consume Corn 100.");
        RepositoryProxy.Instance().ask(Corn.class, 100);

        System.out.println("---------- Test Factory ----------");
        System.out.println("Create order factory.");
        OrderFactory orderFactory = new OrderFactory();

        System.out.println("---------- Test Status ----------");
        System.out.println("Buy two kilogram corn.");
        Order order1 = orderFactory.getOrder("BUY");
        order1.createOrder(Corn.class, 2, 5.00);

        System.out.println("---------- Test Status ----------");
        System.out.println("Sale two kilogram corn.");
        Order order3 = orderFactory.getOrder("SALE");
        order3.createOrder(Corn.class, 2, 5.00);

        System.out.println("---------- Test Null Object ----------");
        System.out.println("Create wrong order");
        Order order2 = orderFactory.getOrder("SAL");
        order2.createOrder(Corn.class, 2, 5.00);

        System.out.println("Firstly get RepositoryProxy Instance.");
        OrderSummary.getSummary().showAllItems();
    }
}
