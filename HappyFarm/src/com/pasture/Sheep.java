package com.pasture;

import com.pasture.Decorator.LongWool;
import com.pasture.Decorator.NormalWool;
import com.pasture.Decorator.Wool;

public class Sheep extends Animal {
    public int wool;
    public static String product = "Wool";

    public Sheep(int id) {
        this.id = id;
        this.hungryPoint = 1;
        this.happyPoint = 2;
        this.food = "Grass";
        this.type = "Sheep";
        this.wool = 8;
    }

    public Wool beSheared(int quantity, String woolType){
        if (wool < quantity) {
            System.out.println("Too much wool needed to be sheared!");
            return null;
        }
        this.wool -= quantity;
        if(woolType.equals("Normal")){
            System.out.println("Having gotten " + quantity + " normal wool from sheep (id: " + this.id + ")!");
            return new NormalWool(quantity);
        } else if(woolType.equals("Long")) {
            System.out.println("Having gotten " + quantity + " long wool from sheep (id: " + this.id + ")!");
            return new LongWool(quantity);
        }
        return null;
    }
}