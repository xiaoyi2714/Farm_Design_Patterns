package com.pasture.Facade;

public class ChickenPoo implements AnimalPoo {
 
    @Override
    public void run(int quantity) {
        // todo 加入粪便
        System.out.println("The chicken poo " + quantity + " chicken stool.");
    }
}