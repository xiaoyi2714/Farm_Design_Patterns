package com.farm;

import com.shop.employee.*;

public class SeedPlantProductParser {
    public static Class seedToPlant(Class cls)
    {
        if (cls== CornSeed.class){
            return CornPlant.class;
        }
        else if (cls==PotatoSeed.class){
            return PotatoPlant.class;
        }
        else if(cls==WheatSeed.class){
            return WheatPlant.class;
        }
        else{
            return null;
        }
    }
}
