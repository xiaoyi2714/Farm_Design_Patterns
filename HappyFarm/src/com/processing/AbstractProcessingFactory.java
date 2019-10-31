package com.processing;
/**
 * 抽象工厂, 观察者模式的调度中心，持有State模式的环境类,享元模式的中心
 * @author linyi
 *
 */
public interface AbstractProcessingFactory {

	/**
	 * 添加生产具体产品的函数
	 */
	
	//增加机器
	void addMachine();
	//移除机器
	void removeMachine(int index);
	//获取机器的状态
	void getMachinesState();
	//设定环境
	void setEnvironment(Environment environment);
	//根据外界环境来控制工厂条件
	void handle();
	void doProcess(Request request, Response response, FactoryChain chain);
}
