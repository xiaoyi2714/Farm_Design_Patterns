package com.farm.command;

public abstract class Command {
	public abstract boolean execute();
	public abstract int execute(Class cls);
}
