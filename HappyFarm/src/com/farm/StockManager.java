package com.farm;

import java.util.ArrayList;
import java.util.List;

import com.farm.command.Command;

//这个类执行FarmManager产生的各种Commands的execute()，代替farm前往item进行各类操作，因为不知道item的具体的接口
//所以这样可以解耦。
public class StockManager {
	
	private List<Command> commandList = new ArrayList<Command>(); 
	
	public void addCommand(Command c)
	{
		commandList.add(c);      
	}

	public void exeAllCommand()
	{
		for (Command c : commandList) {
			c.execute();
		}
		commandList.clear();
	}

	public boolean exeACommand(Command c)
	{
		return c.execute();
	}

	public int exeACommand(Command c, Class cls) {
		// TODO Auto-generated method stub
		return c.execute(cls);
	}

}
	
