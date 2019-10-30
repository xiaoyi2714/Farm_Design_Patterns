package com.farm;

class WheatPlant implements Plant{
	private int presentGrowth=0;
    private final static int maxGrowth=80;
    private final static String name="小麦植株";
    

    @Override
    public void grow(int num)
    {
    	presentGrowth+=num;
    	if (presentGrowth>maxGrowth) {
    		presentGrowth=maxGrowth;
    	}
    }
    @Override
    public String getName()
    {
    	return name;
    }
    @Override
    public int getPresentGrowth()
    {
    	return presentGrowth;
    }
    @Override
    public int getMaxGrowth()
    {
    	return maxGrowth;
    }
}
