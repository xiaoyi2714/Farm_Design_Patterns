package com.farm.command;

import com.shop.repository.RepositoryProxy;

//展示仓库所有item的命令
public class ShowAllCommand extends Command{
	@Override
	public boolean execute()
	{
		return true;
	}


	@Override
	public int execute(Class cls) {
		RepositoryProxy.Instance().showAllItems();
		return 0;
	}

}
