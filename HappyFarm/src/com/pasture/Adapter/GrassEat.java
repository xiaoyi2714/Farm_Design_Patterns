package com.pasture.Adapter;

import com.pasture.Animal;

public class GrassEat implements AnimalEat {
    EatingAdapter eatingAdapter;

    @Override
   public void eat(String eatingType, Animal animal) {
        if(eatingType.equals("Grass")) {
            int foodToEat = animal.hungryPoint;
            System.out.println("There are infinity Grass in store,"
                    + " and the " + animal.type+ " needs " + foodToEat + " Grass.");

            animal.hungryPoint = animal.hungryPoint - foodToEat;
            System.out.println("Animal (id: " + animal.id + ") have eaten "
                    + foodToEat + " " + animal.food + "!");
        }
        else if(eatingType.equals("Normal")) {
            eatingAdapter = new EatingAdapter("Normal");
            eatingAdapter.eat(eatingType, animal);
        }

   }   
}