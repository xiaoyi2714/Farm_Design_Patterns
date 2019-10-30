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

    public static Class plantToProduct(Class cls)
    {
        if (cls== CornPlant.class){
            return Corn.class;
        }
        else if (cls==PotatoPlant.class){
            return Potato.class;
        }
        else if(cls==WheatPlant.class){
            return Wheat.class;
        }
        else{
            return null;
        }
    }
}
