package com.farm;

class PlantFactory {
	private static PlantFactory instance;
	//单实例私有构造函数
	private PlantFactory()
	{

	}
	public static PlantFactory getInstance()
    {
        if (instance == null) {
        	instance = new PlantFactory();
        }
        return instance;
    }
	//生产输入种子对应的植株
	public static Plant getAPlant(Class cls) {
		Class plantClass = SeedPlantProductParser.seedToPlant(cls);
		if (plantClass==null)
		{
			return null;
		}

		Plant newPlant = null;
		try {
			newPlant = (Plant) plantClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}

		return newPlant;
	}

}
