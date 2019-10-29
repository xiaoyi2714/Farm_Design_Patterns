package com.farm;

public interface Plant {
	//当经过一定时间或者施肥就成长。 
    public void grow(int num);
    
    public String getName();
    public int getPresentGrowth();
    public int getMaxGrowth();
}
