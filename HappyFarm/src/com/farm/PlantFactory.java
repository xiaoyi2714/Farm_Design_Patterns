package com.farm;

class PlantFactory {
	private static PlantFactory instance;
	public static PlantFactory getInstance()
    {
        if (instance == null) {
        	instance = new PlantFactory();
        }
        return instance;
    }
	
	public static Class seeding(Class cls)
	{
		return SeedPlantProductParser.seedToPlant(cls);
	}
}
