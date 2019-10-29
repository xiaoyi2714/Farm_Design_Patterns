package com.farm.command;

import com.shop.order.Corn;
import com.shop.repository.RepositoryProxy;

public class AddItemCommand extends Command{
	@Override
	public boolean execute()
	{
		return false;
	}

	@Override
	public int execute(Class cls) {
		RepositoryProxy.Instance().add(Corn.class, 1);
		return 1;
	}
}
