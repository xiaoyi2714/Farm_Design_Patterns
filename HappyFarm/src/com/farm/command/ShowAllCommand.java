package com.farm.command;

public class ShowAllCommand extends Command{
	@Override
	public boolean execute()
	{
		return true;
	}


	@Override
	public int execute(Class cls) {
		return 0;
	}

}
