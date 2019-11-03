package com.pasture.Facade;

public class CatPoo implements AnimalPoo {
 
    @Override
    public void run(int quantity) {
        // todo 加入粪便
        System.out.println("The cat poo " + quantity + " cat stool.");
    }
}