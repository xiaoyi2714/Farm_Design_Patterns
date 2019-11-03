package com.pasture.Decorator;

import com.pasture.Animal;

public class BlueWoolDecorator extends WoolDecorator {
    public BlueWoolDecorator(Wool decoratedWool) {
        super(decoratedWool);
    }

    @Override
    public String getDescription() {
        return decoratedWool.getDescription() + "\n____And it has been set to blue now.";
    }
}