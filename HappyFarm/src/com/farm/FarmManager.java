package com.farm;
import com.shop.employee.CornSeed;
import com.shop.employee.PotatoSeed;
import com.shop.employee.WheatSeed;
import com.farm.command.*;

public class FarmManager {
	
    private static FarmManager farmManagerInstance;
    private FieldManager field;
    private StockManager stock;

    private FarmManager(FieldManager _field, StockManager _stock){
        this.field = _field;
        this.stock = _stock;
    }
    
    
    //此为单实例类 
    //初始化操作与获取实例操作  
    
    public static FarmManager getInstance()
    {
        if (farmManagerInstance == null) {
        	farmManagerInstance = new FarmManager(FieldManager.getInstance(), new StockManager());
        }
        return farmManagerInstance;
    }

    
    //对外开放的农田操作
    //输入种子成为植株
    public boolean seeding(Class cls)
    {
    	int emptyField=field.getAnEmptyField();
		return seeding(cls, emptyField);
    }
    //重载，指定在第fieldIndex种
    public boolean seeding(Class seedClass, int fieldIndex)
	{
    	Class plantClass=PlantFactory.seeding(seedClass);

    	if (plantClass==null){
			System.out.println("尝试在"+fieldIndex+
					"号田种下一个不认识的植物。种植结果：失败");
			return false;
		}
		Plant newPlant= null;
		try {
			newPlant = (Plant) plantClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(stock.exeACommand(new QueryItemCommand(),seedClass)<=0) {
    		System.out.println("尝试在"+fieldIndex+
					"号田种下一个" + newPlant.getName()+
					"。种植结果：种子不足");
    		return false;
    	}
    	if (field.addPlant(newPlant, fieldIndex)>=0){
    		
    		System.out.println("成功在"+fieldIndex+
    							"号田种下一个" + newPlant.getName()+"。");
			stock.exeACommand(new DelItemCommand(),seedClass);
    		return true;
    	}
    	else {
    		System.out.println("尝试在"+fieldIndex+"号田种植种子。种植失败：这块田已有植物");
    	}
    	return false;
    }
    
    public void showAllItems()
    {
    	stock.exeACommand(new ShowAllCommand());
    }
    //展示田里所有植物的类型和成长值
    public void showAllPlants()
    {
    	System.out.println();
    	System.out.println("我们的农田：");
    	if (field.getNumFields()==0) {
    		System.out.println("空");
    	}
    	for (int i=0;i<field.getNumFields();i++) {
    		Plant temp = field.getPlantByField(i);
    		if (temp!=null) {
    			System.out.println("第" + i + "块田种着" + 
    							temp.getName() + ",成长值为"
    							+ temp.getPresentGrowth() + "/" 
    							+ temp.getMaxGrowth() + ".");
    		}
    	}
    	System.out.println();
    }
    
    //取得植物
    public Plant getPlantByField(int index)
    {
    	return field.getPlantByField(index);
    }
    
    
    //提供肥料
    public boolean giveFertilizer(int fieldIndex, Class cls)
    {	
    	Plant plantToGive=field.getPlantByField(fieldIndex);
    	if (plantToGive==null) {
    		System.out.println("尝试为"+fieldIndex+
    				"号田施肥（"+cls.getSimpleName()+"）。施肥结果：这块田没有植物，无法施肥");
    		return false;
    	}
    	
    	if (plantToGive.getPresentGrowth() >= plantToGive.getMaxGrowth()) {
    		System.out.println("尝试为"+fieldIndex+ 
    							"号田的植物——"+plantToGive.getName()+"施肥（"+
								cls.getSimpleName()+"）。施肥结果：该植株已成熟，无需施肥");
    		return false;
    	}
    	
    	if (stock.exeACommand(new QueryItemCommand(),cls)<=0) {
    		System.out.println("尝试为"+fieldIndex+ 
					"号田的植物——"+plantToGive.getName()+"施肥（"+
					cls.getSimpleName()+"）。施肥结果：你没有对应的肥料。");
    		return false;
    	}
    	plantToGive.grow(FertilizerGrowthParser.FertilizerToGrowth(cls));
    	System.out.println("为"+fieldIndex+
    						"号田的植物——"+plantToGive.getName()+
    						"施肥（"+cls.getSimpleName()+"），增加成长值"+FertilizerGrowthParser.FertilizerToGrowth(cls)+"，该植物成长值"+plantToGive.getPresentGrowth()+
    						"/"+plantToGive.getMaxGrowth()+"。");
		stock.exeACommand(new DelItemCommand(),cls);
    	return true;
    }
    //收获函数
    public Plant harvest(int fieldIndex)
    {
    	Plant p=field.harvest(fieldIndex);
    	if (p==null) {
    		System.out.println("尝试收割第"+fieldIndex+"块田：无法收割，这里没有植物");
    		return null;
    	}
    	return p;
    }

    
}
