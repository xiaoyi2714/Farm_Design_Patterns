package com.farm;

public class Field {
	private int index;
	private Plant plant;
	//构造函数
	Field(int _index)
	{
		this.index=_index;
	}
	//构造函数
	public Field(int fieldIndex, Plant newPlant) {
		// TODO Auto-generated constructor stub
		this.index=fieldIndex;
		plant=newPlant;
	}
	//添加植物
	public boolean addPlant(Plant plantToAdd)
	{
		if (plant!=null) {
			return false;
		}
		plant=plantToAdd;
		return true;
	}
	//取得植物
	public Plant getPlant()
	{
		return plant;
	}
	//取得这块田的索引
	public int getIndex()
	{
		return index;
	}
	//删除植物并返回
	public Plant delPlant()
	{
		Plant plantDel=plant;
		plant=null;
		return plantDel;
	}
}
