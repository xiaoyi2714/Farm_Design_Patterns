package com.processing;

public interface AbstractProcessingFactory {
	//add machine
	void addMachine();
	//remove machine
	void removeMachine(int index);
	//get machines' state
	void getMachinesState();
	//set environment
	void setEnvironment(Environment environment);
	//control factory's environment
	void handle();
	void doProcess(Request request, Response response, FactoryChain chain);
}
