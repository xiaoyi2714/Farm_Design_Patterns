package com.farm.command;

//命令模式
public abstract class Command {
	//执行操作
	public abstract boolean execute();
	//带参数的执行操作
	public abstract int execute(Class cls);
}
