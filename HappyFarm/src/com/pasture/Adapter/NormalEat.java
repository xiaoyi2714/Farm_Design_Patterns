package com.pasture.Adapter;

import com.pasture.Animal;

public class NormalEat implements AdavanceAnimalEat {
    public void eat(Animal animal) {
        int foodInStore = 2;
        int foodNeeded = animal.hungryPoint;
        System.out.println("There are " + foodInStore + " " + animal.food
                + " in store, and the " + animal.type + " needs " + foodNeeded + " " + animal.food +".");

        if (foodInStore <= 0) {
            System.out.println("Warning: There are not enough food for animal!");
        } else {
            int foodToEat = foodInStore < foodNeeded ? foodInStore : foodNeeded;
            animal.hungryPoint = animal.hungryPoint - foodToEat;
            System.out.println("Animal (id: " + animal.id + ") have eaten "
                    + foodToEat + " " + animal.food + "!");
        }
    }
}
