package com.pasture.Bridge;

public class AnimalYell {
    private YellAPI yellAPI;
 
    public AnimalYell(YellAPI yellAPI) {
        this.yellAPI = yellAPI;
    }
 
    public void yell(int time) {
        yellAPI.animalYell(time);
    }
}