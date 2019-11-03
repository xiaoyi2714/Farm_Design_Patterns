package com.pasture.Decorator;

public class LongWool implements Wool {
    private int quantity;
    public LongWool(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getDescription() {
        return String.format("This is %d long wool ", this.quantity);
    }
}
