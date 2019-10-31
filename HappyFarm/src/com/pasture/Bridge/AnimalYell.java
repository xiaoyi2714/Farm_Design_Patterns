package com.pasture.Bridge;

public class AnimalYell {
    private int time;
    private YellAPI yellAPI;
 
    public AnimalYell(YellAPI yellAPI, int time) {
        this.time = time;
        this.yellAPI = yellAPI;
    }
 
    public void yell() {
        yellAPI.animalYell(time);
    }
}