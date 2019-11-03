package com.pasture.Facade;

public class AnimalPooMaker {
    private AnimalPoo catPoo;
    private AnimalPoo chickenPoo;
    private AnimalPoo sheepPoo;
 
    public AnimalPooMaker() {
        catPoo = new CatPoo();
        chickenPoo = new ChickenPoo();
        sheepPoo = new SheepPoo();
    }
 
    public void pooForCat(int quantity) {
        catPoo.run(quantity);
    }
    public void pooForChicken(int quantity) {
        chickenPoo.run(quantity);
    }
    public void pooForSheep(int quantity) {
        sheepPoo.run(quantity);
    }
}