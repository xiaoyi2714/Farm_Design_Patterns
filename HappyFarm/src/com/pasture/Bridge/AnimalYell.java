package com.pasture.Bridge;

public abstract class AnimalYell {

    protected YellTimes yellTimes;

    public void setYellTimes(YellTimes yellTimes) {
        this.yellTimes = yellTimes;
    }

    public abstract void yell();
}