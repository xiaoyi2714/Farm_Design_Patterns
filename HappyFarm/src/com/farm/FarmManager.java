package com.farm;
import com.farm.memento.FieldMemento;
import com.farm.command.*;
import com.farm.memento.FieldMementoManager;

public class FarmManager {
	
    private static FarmManager farmManagerInstance;
    private FieldManager field;
    private StockManager stock;
	//构造函数
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
		Plant newPlant=PlantFactory.getAPlant(seedClass);

		if (newPlant==null){
			System.out.println("Fail planting");
			return false;
		}
		if(stock.exeACommand(new QueryItemCommand(),seedClass)<=0) {
    		System.out.println("Fail planting seed not enough");
    		return false;
    	}
    	if (field.addPlant(newPlant, fieldIndex)>=0){
    		
    		System.out.println("On "+fieldIndex+
    							" plant a new " + newPlant.getName()+".");
			stock.exeACommand(new DelItemCommand(),seedClass);
    		return true;
    	}
    	else {
    		System.out.println("There is already a plant");
    	}
    	return false;
    }
    

    //展示田里所有植物的类型和成长值
    public void showAllPlants()
    {
    	System.out.println();
    	System.out.println("Our field:");
    	if (field.getNumPlants()==0) {
    		System.out.println("empty");
    	}
    	for (int i=0;i<field.getNumFields();i++) {
    		Plant temp = field.getPlantByField(i);
    		if (temp!=null) {
    			System.out.println("No." + i + " field" +
    							temp.getName() + ", growth"
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
    		System.out.println("Try to give No."+fieldIndex+
    				" field "+cls.getSimpleName()+"), fail.");
    		return false;
    	}
    	
    	if (plantToGive.getPresentGrowth() >= plantToGive.getMaxGrowth()) {
    		System.out.println("Fail to give fertilizer.");
    		return false;
    	}
    	
    	if (stock.exeACommand(new QueryItemCommand(),cls)<=0) {
    		System.out.println("Fail, fertilizer not enough.");
    		return false;
    	}
    	plantToGive.grow(FertilizerGrowthParser.FertilizerToGrowth(cls));
    	System.out.println("No."+fieldIndex+
    						" field, "+plantToGive.getName()+
    						"give "+cls.getSimpleName()+"), grow "+FertilizerGrowthParser.FertilizerToGrowth(cls)+", present"+plantToGive.getPresentGrowth()+
    						"/"+plantToGive.getMaxGrowth()+"。");
		stock.exeACommand(new DelItemCommand(),cls);
    	return true;
    }
    //收获函数
    public Plant harvest(int fieldIndex)
    {
		Plant p = field.getPlantByField(fieldIndex);

    	if (p==null) {
    		System.out.println("Fail, no plant here.");
    		return null;
    	}
    	else if (p.getPresentGrowth() < p.getMaxGrowth()) {
			System.out.println("Fail, not mature plant");
			return null;
		}

		field.harvest(fieldIndex);
    	System.out.println("Harvest: No."+fieldIndex+" field, "+p.getName());

    	stock.exeACommand(new AddItemCommand(),ProductFactory.getProductionClass(p.getClass()));
    	return p;
    }

    //提供接口调用备忘录保存
	public FieldMemento saveFieldStatus()
	{
		System.out.println();
		System.out.println("Saving memento:");
		showAllPlants();
		FieldMemento m = field.save();
		if (m!=null) {
			System.out.println("Success.");
			System.out.println();
			return m;
		}
		else{
			System.out.println("Fail.");
			System.out.println();
			return null;
		}
	}
	//提供接口调用备忘录恢复
	public void restore(int index) {
		System.out.println("Restoring No." + index + " memento.");
		FieldMemento m = FieldMementoManager.getInstance().getMemento(index);
		if (m!=null) {
			field.restore(m);
		}
		showAllPlants();
		System.out.println("Succeed.");
	}
	//提供接口展示所有
	public void showAllFieldMementos()
	{
		FieldMementoManager.getInstance().showAllMementos();
	}
}
