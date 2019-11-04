package com.shop.employee;

public class OrganicFertilizer implements Item, Fertilizer {
    private String name="OrganicFertilizer";
    //获取单价
    public Double getprice(){
        return 6.0;
    }

    @Override
    public int getGrowthPoint()
    {
        return 50;
    }
}
