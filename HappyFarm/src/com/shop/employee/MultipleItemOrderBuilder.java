package com.shop.employee;



import java.util.HashMap;
import java.util.Map;

public class MultipleItemOrderBuilder {
    private Map<Class, Double> items = new HashMap<>();

    public void additem(Class cls,Double totalCost){
        items.put(cls,totalCost);
    }
    //输入清单然后返回总价
    public Double getCost(Map<Class, Integer> List){
        Double total = 0.0;
        for(Map.Entry<Class, Integer> entry : List.entrySet()) {
            Double cost = 0.0;
            String mapKey = entry.getKey().getSimpleName();
            System.out.println("We use " + mapKey + " to build the order!");
            Integer mapValue = entry.getValue();
            switch(mapKey){
                case "Potato": {
                    cost += mapValue * new Potato().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Corn":{
                    cost += mapValue * new Corn().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Chicken":{
                    cost += mapValue * new Chicken().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "ChickenKebabs":{
                    cost += mapValue * new ChickenKebabs().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Egg":{
                    cost += mapValue * new Egg().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "EggCake":{
                    cost += mapValue * new EggCake().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Flour":{
                    cost += mapValue * new Flour().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Wheat":{
                    cost += mapValue * new Wheat().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Wool":{
                    cost += mapValue * new Wool().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "CatFood":{
                    cost += mapValue * new CatFood().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case " ChemicalFertilizer":{
                    cost += mapValue * new ChemicalFertilizer().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "ChickenFood":{
                    cost += mapValue * new ChickenFood().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "CornSeed":{
                    cost += mapValue * new CornSeed().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "DogFood":{
                    cost += mapValue * new DodFood().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "LittleChicken":{
                    cost += mapValue * new LittleChicken().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "OrganicFertilizer":{
                    cost += mapValue * new OrganicFertilizer().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "PotatoSeed":{
                    cost += mapValue * new PotatoSeed().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "Sheep":{
                    cost += mapValue * new Sheep().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                case "WheatSeed":{
                    cost += mapValue * new WheatSeed().getprice();
                    this.additem(entry.getKey(),cost);
                    total += cost;
                    break;
                }
                default:
                    break;
            }

        }
        return total;
    }
}
