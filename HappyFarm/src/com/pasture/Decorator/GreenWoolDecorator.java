package com.pasture.Decorator;

import com.pasture.Sheep;

public class GreenWoolDecorator extends WoolDecorator {
 
    public GreenWoolDecorator(Sheep sheep, int quantity) {
        super(sheep, quantity);

    }
 
    @Override
    public void shearing(Sheep sheep, int quantity) {
        NormalWool normalWool = new NormalWool();
        normalWool.shearing(sheep, quantity);       
        dyeGreenWool(quantity);
    }
 
    private void dyeGreenWool(int quantity){
        System.out.println("Having dyed " + quantity + "wool into green color successfully!");
    }
}