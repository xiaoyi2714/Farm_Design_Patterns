package com.farm.command;

import com.shop.repository.Repository;
import com.shop.repository.RepositoryProxy;

import java.util.*;

//尝试查询某个item的数量
public class QueryItemCommand extends Command{
	@Override
	public boolean execute()
	{
		return true;
	}


	@Override
	public int execute(Class cls) {
		Integer num=RepositoryProxy.Instance().checkItemNum(cls);
		if (num==null){
			return 0;
		}
		return num;
	}
}
