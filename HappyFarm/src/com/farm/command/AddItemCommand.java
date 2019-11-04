package com.farm.command;

import com.shop.repository.RepositoryProxy;


//在仓库添加item
public class AddItemCommand extends Command{
	@Override
	public boolean execute()
	{
		return false;
	}

	@Override
	public int execute(Class cls) {
		RepositoryProxy.Instance().add(cls, 1);
		return 1;
	}
}
