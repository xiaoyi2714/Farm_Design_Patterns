package com.shop.employee;

public class ChemicalFertilizer implements Item, Fertilizer {
    private String name="ChemicalFertilizer";
    //获取单价
    public Double getprice(){
        return 10.0;
    }

    @Override
    public int getGrowthPoint()
    {
        return 20;
    }
}
