package com.pasture.Decorator;

import com.pasture.Sheep;

public class RedWoolDecorator extends WoolDecorator {
 
    public RedWoolDecorator(Sheep sheep, int quantity) {
        super(sheep, quantity);
    }

    @Override
    public void shearing(Sheep sheep, int quantity) {
        NormalWool normalWool = new NormalWool();
        normalWool.shearing(sheep, quantity);         
        dyeRedWool(quantity);
        //加入仓库
    }
 
    private void dyeRedWool(int quantity){
        System.out.println("Having dyed " + quantity + "wool into red color successfully!");
    }
}