package com.pasture.Factory;

import com.pasture.Animal;

import com.pasture.Sheep;
import com.pasture.Cat;
import com.pasture.Chicken;

public class FactoryDemo {
    public int id = 0;

    public Animal run(String type) {
        if (type.equals("Cat")){
            id = id + 1;
            System.out.println("Create a new cat!");
            return new Cat(id);
        } else if (type.equals("Sheep")) {
            id = id + 1;
            System.out.println("Create a new sheep!");
            return new Sheep(id);
        } else if (type.equals("Chicken")) {
            id = id + 1;
            System.out.println("Create a new chicken!");
            return new Chicken(id);
        } else {
            System.out.println("Wrong parameter!");
            return null;
        }
    }
}