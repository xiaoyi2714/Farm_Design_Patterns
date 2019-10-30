package com.farm;

public interface Plant {
	//当施肥就成长。
    public void grow(int num);
    //输出时取得名字
    public String getName();
    //取得当前成长值
    public int getPresentGrowth();
    //取得最大成长值
    public int getMaxGrowth();
}
