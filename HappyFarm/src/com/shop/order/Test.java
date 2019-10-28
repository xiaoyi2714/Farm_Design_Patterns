package com.shop.order;

import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;
import com.shop.order.singleton.OrderSummary;
import com.shop.repository.RepositoryProxy;

public class Test {

    public static void main(String[] args) {

        RepositoryProxy.Instance().add(Corn.class, 2);
        RepositoryProxy.Instance().add(Corn.class, 2);
        RepositoryProxy.Instance().showAllItems();

        OrderFactory orderFactory = new OrderFactory();

        Order order1 = orderFactory.getOrder("BUY");

        order1.createOrder(Corn.class, 2, 5.00);

        Order order2 = orderFactory.getOrder("SALE");

        order2.createOrder(Corn.class, 2, 5.00);

        Order order3 = orderFactory.getOrder("SALE");

        order3.createOrder(Corn.class, 2, 5.00);

        OrderSummary.getSummary().showAllItems();
    }

}
