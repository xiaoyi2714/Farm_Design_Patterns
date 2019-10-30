package com.processing;

import java.util.Random;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("单元测试");
		
		System.out.println("-----------------------");
		System.out.println("初始化,抽象工厂测试");
		FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
		PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
		for(int i = 0;i<15;i++) {
			farmProcessingFactory.addMachine();
			pastureProcessingFactory.addMachine();
		}
		farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
		farmProcessingFactory.handle();
		pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
		pastureProcessingFactory.handle();
		
		System.out.println("-----------------------");
		System.out.println("观察者模式测试,原型模式测试");
		System.out.println("农场加工厂机器状态检查:");
		farmProcessingFactory.getMachinesState();
		System.out.println("牧场加工厂机器状态检查:");
		pastureProcessingFactory.getMachinesState();
		
		System.out.println("-----------------------");
		System.out.println("状态模式测试");
		Random random = new Random();
		int temprature = random.nextInt(20) + 10;
		int humidity = random.nextInt(25) + 10; 
		farmProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
		System.out.println("农场加工厂环境检查:");
		farmProcessingFactory.handle();
		temprature = random.nextInt(20) + 10;
		humidity = random.nextInt(25) + 10; 
		pastureProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
		System.out.println("牧场加工厂环境检查:");
		farmProcessingFactory.handle();
		random = null;

		System.out.println("-----------------------");
		System.out.println("模板模式测试");
		farmProcessingFactory.execute();
		pastureProcessingFactory.execute();
	}
}
