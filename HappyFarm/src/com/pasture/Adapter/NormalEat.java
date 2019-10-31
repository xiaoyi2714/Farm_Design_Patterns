package com.pasture.Adapter;

import com.pasture.Animal;

public class NormalEat implements AnimalEat {
 
   @Override
   public void eat(Animal animal) {
        if (animal.food.equals("Grass")) {
            GrassEat grassEat = new GrassEat();
            grassEat.eat(animal);
        } else {
            //TODO 把item的东西移动过来
            int foodInStore = 100;
            int foodNeeded = animal.hungryPoint;
            System.out.println("There are " + foodInStore + " " + animal.food 
            + " in store, and the " + animal.name + " needs " + foodNeeded + " " + animal.food +".");

            if (foodInStore <= 0) {
                System.out.println("Warning: There are not enough food for animal!");
            } else {
                int foodToEat = foodInStore < foodNeeded ? foodInStore : foodNeeded;
                animal.hungryPoint = animal.hungryPoint - foodToEat;
                // TOdo store中的food也要减
                System.out.println("Animal (id: " + animal.id + ") have eaten " 
                + foodToEat + " " + animal.food + "!");
            }
        }
   }   
}