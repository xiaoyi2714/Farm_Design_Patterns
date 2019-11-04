package com.shop.order;

import com.shop.order.singleton.OrderSummary;
import com.shop.order.state.DeliveredStatus;
import com.shop.order.state.OrderStatus;
import com.shop.order.state.PaidStatus;
import com.shop.order.state.UnpaidStatus;
import com.shop.repository.RepositoryProxy;
import com.shop.store.SingleStore;

import java.util.Map;

public class OrderImpl {

    //私有变量
    //订单类型
    private String type;
    //订单商品列表
    private Map<Class, Integer> orderList;
    //金额
    private Double money;
    //订单状态
    private OrderStatus mStatus;

    //构造函数
    public OrderImpl(){
        //初始状态为Unpaid
        mStatus = new UnpaidStatus();
    }

    //构造函数
    public OrderImpl(String type, Map<Class, Integer> orderList, Double money){
        this.type = type;
        this.orderList = orderList;
        this.money = money;
        //初始状态为Unpaid
        mStatus = new UnpaidStatus();
    }

    //设置状态
    protected void setStatus(OrderStatus status){
        this.mStatus = status ;
    }

    //检查库存是否够用
    protected boolean checkInventory(){
        RepositoryProxy repo = RepositoryProxy.Instance();
        switch (type) {
            case "BUY":
                return true;
            case "SALE":
                for (Map.Entry<Class, Integer> entry : orderList.entrySet()) {
                    if(entry.getValue() > repo.checkItemNum(entry.getKey())){
                        System.out.println("Insufficient inventory");
                        return false;
                    }
                }
                return true;
            default:
                System.out.println("Operator error");
                return false;
        }
    }

    //更新金钱
    public void updateMoney(){
        SingleStore.getSingleStore().updateProfit(money, type);
    }
    //更新库存
    public void updateInventory(){
        RepositoryProxy repo = RepositoryProxy.Instance();
        switch (type) {
            case "BUY":
                repo.add(orderList);
                break;
            case "SALE":
                repo.ask(orderList);
                break;
            default:
                System.out.println("Operator error");
        }
        System.out.println("Inventory updated");
    }

    //更新summary
    public void updateSummary(){
        OrderSummary summary = OrderSummary.getSummary();
        summary.add(orderList);
        System.out.println("Summary updated");
    }

    //支付
    public void pay() {
        mStatus.pay(this);
        System.out.println("Payment received");
        // 当前下的状态调用支付，然后把当前状态设置为Paid的状态
        setStatus(new PaidStatus());
    }

    //创建订单失败退款
    public void refund(){
        switch (type) {
            case "BUY":
                type = "SALE";
                break;
            case "SALE":
                type = "BUY";
                break;
            default:
                System.out.println("operator error");
        }
        this.updateMoney();
        System.out.println("Refunded");
    }

    //发货
    public boolean deliverGoods() {
        if (checkInventory()) {
            // 更新库存
            mStatus.deliverGoods(this);
            // 更新库存之后，把状态置为Delivered状态
            setStatus(new DeliveredStatus());
            return true;
        }
        else
            return false;
    }


}
