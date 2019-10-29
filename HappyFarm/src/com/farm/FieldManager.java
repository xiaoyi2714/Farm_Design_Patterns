package com.farm;
import java.util.*;

class FieldManager {
	private static FieldManager fieldInstance;
    private List<Field> fieldList;
    //私有构造函数，成为单实例变量
    private FieldManager(){
        fieldList = new ArrayList<Field>();
        for (int i=0;i<50;i++) {
        	fieldList.add(new Field(i));
        }
    }
    //取得类的实例
    public static FieldManager getInstance()
    {
        if (fieldInstance == null) fieldInstance = new FieldManager();
        return fieldInstance;
    }
    
    //取得一块空地
    public int getAnEmptyField()
    {
    	for(int i=0;i<fieldList.size();i++) {
    		if(fieldList.get(i).getPlant()==null) {
    			return i;
    		}
    	}
    	if (expand()){
    		return fieldList.size()-1;
    	}
    	return -1;
    }
    private boolean expand()
    {
    	return fieldList.add(new Field(fieldList.size()));
    }
    //取得植物总数
    public int getNumPlants()
    {
    	int count=0;
    	for(int i=0;i<fieldList.size();i++) {
    		if (fieldList.get(i).getPlant()!=null) {
    			count++;
    		}
    	}
    	return count; 
    }
    public int getNumFields()
    {
    	return fieldList.size(); 
    }
    
    
    public List<Field> getAllField()
    {
    	return fieldList;
    }
    public List<Plant> getAllPlants()
    {
    	List<Plant> list=new ArrayList<Plant>();
    	for (int i=0;i<fieldList.size();i++) {
    		list.add(fieldList.get(i).getPlant());
    	}
    	return list;
    }
    //输入田号取得植物
    public Plant getPlantByField(int fieldIndex)
    {
    	return fieldList.get(fieldIndex).getPlant();
    }
    //往田里种植物，返回种的田
    
    public int addPlant(Plant newPlant, int fieldIndex)
    {
    	if (fieldIndex<0) {
    		return -2;
    	}
    	while (fieldIndex>=fieldList.size()) {
    		expand();
    	}
    	if (newPlant==null) {
    		return -3;
    	}
    	//田里已有植物
    	if (getPlantByField(fieldIndex)!=null) {
    		return -1;
    	}
    	//在对应的田添加植物
    	
    	if (fieldList.get(fieldIndex).addPlant(newPlant)) {
    		return fieldIndex;
    	}
    	return -4;
    }
    
    //删掉田里的植物，可能是收割完成后这么做。
    public Plant harvest(int index)
    {
    	return fieldList.get(index).delPlant();
    }
}
