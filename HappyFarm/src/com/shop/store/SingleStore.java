package com.shop.store;


import com.shop.employee.EmployeeList;





public class SingleStore implements Store{
    final int FULL = 10000;
    final int ALMOST = 9000;
    final int PROPER = 5000;
    final int EMPTY = 0;
    //获取商店资产
    public Double getProfit() {
        return profit;
    }
    //设定商店资产
    public void setProfit(Double profit) {
        this.profit = profit;
    }

    //资金
    private Double profit = 10000.00;
    //员工清单
    private SaleStrategy strategy = new goldVIP();
    private static SingleStore instance = new SingleStore();
    private SingleStore(){};
    //返回一个SingleStore实例,商店起始资金10000.0，没有员工
    //用store不要new，直接SingleStore.getSingleStore();
    //返回一个SingleStore实例
    public static SingleStore getSingleStore(){
        return instance;
    }
    //设定优惠策略
    public void setStrategy(SaleStrategy strategy) {
        this.strategy = strategy;
    }
    public Double getStrategy(){
        return ExecuteStrategy.CalculatePrice(instance.strategy,10.0);
    }
    //通过仓库反馈来维护strategy数据成员
    public  void update(){
        int inventory;
        com.shop.repository.RepositoryProxy repo = com.shop.repository.RepositoryProxy.Instance();
        inventory = repo.getTotalValue();
        if(inventory > EMPTY && inventory < PROPER){
            instance.setStrategy(new normalVIP());
        }
        else if(inventory > PROPER && inventory < ALMOST){
            instance.setStrategy(new goldVIP());
        }
        else if(inventory > ALMOST && inventory < FULL){
            instance.setStrategy(new superVIP());
        }
    }

    //通过员工调用促销策略，计算促销后金额
    public Double useStrategy(Double initialPrice) {
        //需要输入选择的初始金额，策略已经选好了

        //计算使用促销策略后的金额，并返回
        return ExecuteStrategy.CalculatePrice(instance.strategy,initialPrice);
    }

    //订单通过update来更新profit
    public void updateProfit(Double money,String op){
        switch (op){
            //"SALE"代表加钱，”BUY”代表减钱
            case "SALE":{
                instance.setProfit(instance.getProfit() + money);
                break;
            }
            case "BUY":{
                instance.setProfit(instance.getProfit() - money);
                break;
            }
        }
    }

}
