package com.pasture.Strategy;

import com.pasture.Animal;

public class Interaction {
    private Strategy strategy;
 
    public Interaction(Strategy strategy){
        this.strategy = strategy;
    }
 
    public void executeInteraction(Animal animal1, Animal animal2){
        strategy.doOperation(animal1, animal2);
    }
}