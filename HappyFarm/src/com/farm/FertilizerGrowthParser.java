package com.farm;
import com.shop.employee.*;

import com.shop.employee.OrganicFertilizer;

public class FertilizerGrowthParser {
    public static int FertilizerToGrowth(Class cls)
    {
        if (cls==ChemicalFertilizer.class){
            return 20;
        }
        else if(cls== OrganicFertilizer.class){
            return 50;
        }
        return 0;
    }
}
