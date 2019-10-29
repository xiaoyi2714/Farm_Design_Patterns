package com.farm;

class Field {
	private int index;
	private Plant plant;
	
	Field(int _index)
	{
		this.index=_index;
	}
	public Field(int fieldIndex, Plant newPlant) {
		// TODO Auto-generated constructor stub
		this.index=fieldIndex;
		plant=newPlant;
	}
	public boolean addPlant(Plant plantToAdd)
	{
		if (plant!=null) {
			return false;
		}
		plant=plantToAdd;
		return true;
	}
	public Plant getPlant()
	{
		return plant;
	}
	public int getIndex()
	{
		return index;
	}
	public Plant delPlant()
	{
		Plant plantDel=plant;
		plant=null;
		return plantDel;
	}
}
