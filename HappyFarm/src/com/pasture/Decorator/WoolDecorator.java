package com.pasture.Decorator;

import com.pasture.Sheep;

public abstract class WoolDecorator implements Wool {
    @Override
    public void shearing(Sheep sheep, int quantity){
        System.out.println("Error: Do not implement specific decorator!");
    }
}