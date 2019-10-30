package com.farm;

public class ProductFactory {
    private static ProductFactory instance;
    private ProductFactory(){}
    public static ProductFactory getInstance()
    {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
    //生产输入植株收割后的产品
    public static Class getProductionClass(Class cls)
    {
        return SeedPlantProductParser.plantToProduct(cls);
    }
}
