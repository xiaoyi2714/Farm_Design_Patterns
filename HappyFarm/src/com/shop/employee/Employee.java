package com.shop.employee;


import java.util.Map;


import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;
import com.shop.store.SingleStore;


public class Employee {
    private static Employee instance = new Employee();

    public Employee() {
    }

    public static Employee getEmployee() {
        System.out.println("You have successfully employ someone!");
        return instance;
    }

    public static void createSaleOrder(Class cls, Integer value) {
        double singlePrice = 0, initialPrice = 0, cost = 0;
        String type = cls.getSimpleName();
        SingleStore tempStore = SingleStore.getSingleStore();
        //获取单价
        switch (type) {
            case "Potato": {
                singlePrice += new Potato().getprice();
                break;
            }
            case "Corn":{
                singlePrice += new Corn().getprice();
                break;
            }
            case "Chicken":{
                singlePrice += new Chicken().getprice();
                break;
            }
            case "ChickenKebabs":{
                singlePrice += new ChickenKebabs().getprice();
                break;
            }
            case "Egg":{
                singlePrice += new Egg().getprice();
                break;
            }
            case "EggCake":{
                singlePrice += new EggCake().getprice();
                break;
            }
            case "Flour":{
                singlePrice += new Flour().getprice();
                break;
            }
            case "Wheat":{
                singlePrice += new Wheat().getprice();
                break;
            }
            case "Wool":{
                singlePrice += new Wool().getprice();
                break;
            }
            default:
                break;
        }
        //原价
        initialPrice = singlePrice * value;
        //计算现价cost
        cost = tempStore.useStrategy(initialPrice);
        // Map<Class, Integer> map = new HashMap<>();
        // map.put(cls, value);
        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.getOrder("SALE");
        //创建订单
        order.createOrder(cls, value, cost);

    }

    public static void createSaleOrder(Map<Class, Integer> map) {
        double singlePrice = 0, initialPrice = 0, cost = 0;
        SingleStore tempStore = SingleStore.getSingleStore();
        MultipleItemOrderBuilder itemList = new MultipleItemOrderBuilder();
        //创建一个<Class,Double>的List，代表每一项商品以及该商品的总价，并返回所有商品总价的总价
        initialPrice = itemList.getCost(map);
        cost = tempStore.useStrategy(initialPrice);
        //创建订单
        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.getOrder("SALE");
        order.createOrder(map, cost);
    }

    public static void createBuyOrder(Class cls,Integer value) {
        double singlePrice = 0, cost = 0;
        String type = cls.getSimpleName();

        //获取单价
        switch (type) {
            case "CatFood":{
                singlePrice += new CatFood().getprice();
                break;
            }
            case " ChemicalFertilizer":{
                singlePrice += new ChemicalFertilizer().getprice();
                break;
            }
            case "ChickenFood":{
                singlePrice += new ChickenFood().getprice();
                break;
            }
            case "CornSeed":{
                singlePrice += new CornSeed().getprice();
                break;
            }
            case "DogFood":{
                singlePrice += new DodFood().getprice();
                break;
            }
            case "LittleChicken":{
                singlePrice += new LittleChicken().getprice();
                break;
            }
            case "OrganicFertilizer":{
                singlePrice += new OrganicFertilizer().getprice();
                break;
            }
            case "PotatoSeed":{
                singlePrice += new PotatoSeed().getprice();
                break;
            }
            case "Sheep":{
                singlePrice += new Sheep().getprice();
                break;
            }
            case "WheatSeed":{
                singlePrice += new WheatSeed().getprice();
                break;
            }

            default:
                break;
            //未枚举完
        }
        //原价
        cost = singlePrice * value;
        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.getOrder("BUY");
        //创建订单
        order.createOrder(cls, value, cost);
    }

    public static void createBuyOrder(Map<Class, Integer> map) {
        double singlePrice = 0, initialPrice = 0;

        MultipleItemOrderBuilder itemList = new MultipleItemOrderBuilder();
        //创建一个<Class,Double>的List，代表每一项商品以及该商品的总价，并返回所有商品总价的总价
        initialPrice = itemList.getCost(map);
        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.getOrder("SALE");
        //创建订单
        order.createOrder(map, initialPrice);
    }
}

