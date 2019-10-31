package com.pasture;

public class Cat extends Animal {

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Cat(int id) {
        this.id = id;
        this.hungryPoint = 2;
        this.happyPoint = 4;
        this.food = "CatFood";
        this.type = "Cat";
    }
}