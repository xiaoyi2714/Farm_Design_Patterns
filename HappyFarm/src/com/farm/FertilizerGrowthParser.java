package com.farm;
import com.shop.employee.*;

import com.shop.employee.OrganicFertilizer;

public class FertilizerGrowthParser {
    private final static OrganicFertilizer OFInstance = new OrganicFertilizer();
    private final static ChemicalFertilizer CFInstance = new ChemicalFertilizer();
    //输入肥料类，输出成长值。
    public static int FertilizerToGrowth(Class cls)
    {
        if (cls==ChemicalFertilizer.class){
            return CFInstance.getGrowthPoint();
        }
        else if(cls== OrganicFertilizer.class){
            return OFInstance.getGrowthPoint();
        }
        return 0;
    }
}
