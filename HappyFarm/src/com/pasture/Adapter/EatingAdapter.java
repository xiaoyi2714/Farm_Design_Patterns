package com.pasture.Adapter;

import com.pasture.Animal;

public class EatingAdapter implements AnimalEat {
    AdavanceAnimalEat adavanceAnimalEat;

    public EatingAdapter(String eatingType){
        if(eatingType.equals("Normal")){
            adavanceAnimalEat = new NormalEat();
        }
    }
 
   @Override
   public void eat(String eatingType, Animal animal) {
       if(eatingType.equals("Normal")){
           adavanceAnimalEat.eat(animal);
       }
   }   
}