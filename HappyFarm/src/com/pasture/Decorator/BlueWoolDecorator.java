package com.pasture.Decorator;

import com.pasture.Sheep;

public class BlueWoolDecorator extends WoolDecorator {
 
    public BlueWoolDecorator(Sheep sheep, int quantity) {
        super(sheep, quantity);
    }
 
    @Override
    public void shearing(Sheep sheep, int quantity) {
        NormalWool normalWool = new NormalWool();
        normalWool.shearing(sheep, quantity);       
        dyeBlueWool(quantity);
    }
 
    private void dyeBlueWool(int quantity){
        System.out.println("Having dyed " + quantity + "wool into blue color successfully!");
    }
}