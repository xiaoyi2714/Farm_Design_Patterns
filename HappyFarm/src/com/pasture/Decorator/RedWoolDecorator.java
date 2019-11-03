package com.pasture.Decorator;

import com.pasture.Animal;

public class RedWoolDecorator extends WoolDecorator {
    public RedWoolDecorator(Wool decoratedWool) {
        super(decoratedWool);
    }

    @Override
    public String getDescription() {
        return decoratedWool.getDescription() + "\n____And it has been set to red now.";
    }
}