package com.farm.command;

//import com.shop.order.Corn;
import com.shop.repository.RepositoryProxy;

//删除仓库item
public class DelItemCommand extends Command{
	@Override
	public boolean execute()
	{
		return true;
	}


	@Override
	public int execute(Class cls) {
		RepositoryProxy.Instance().ask(cls, 1);
		Integer num=RepositoryProxy.Instance().checkItemNum(cls);
		if (num==null){
			return 0;
		}
		return num;
	}

}
