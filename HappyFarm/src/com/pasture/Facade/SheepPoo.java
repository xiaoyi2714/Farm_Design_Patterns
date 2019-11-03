package com.pasture.Facade;

public class SheepPoo implements AnimalPoo {
 
    @Override
    public void run(int quantity) {
        // todo 加入粪便
        System.out.println("The sheep poo " + quantity + " sheep stool.");
    }
}