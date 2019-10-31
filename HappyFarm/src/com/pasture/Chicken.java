package com.pasture;

public class Chicken extends Animal {
    public static String product = "egg";

    public Chicken(int id) {
        this.id = id;
        this.hungryPoint = 3;
        this.happyPoint = 1;
        this.food = "ChickenFood";
        this.type = "Chicken";
    }
}