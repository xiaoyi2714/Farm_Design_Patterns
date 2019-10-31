package com.pasture.Decorator;

import com.pasture.Sheep;

public class NormalWool extends Wool {
 
    @Override
    public void shearing(Sheep sheep, int quantity) {
        if (sheep.wool < quantity) {
            System.out.println("Too much wool needed to be sheared!");
            return;
        }
        sheep.wool = sheep.wool - quantity;
        //item加入wool
        System.out.println("Having gotten " + quantity 
        + "wool from sheep (id: " + sheep.id + ")!");
    }
}