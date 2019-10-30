package com.processing;

import java.util.Random;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("��Ԫ����");
		
		System.out.println("-----------------------");
		System.out.println("��ʼ��,���󹤳�����");
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
		System.out.println("�۲���ģʽ����,ԭ��ģʽ����");
		System.out.println("ũ���ӹ�������״̬���:");
		farmProcessingFactory.getMachinesState();
		System.out.println("�����ӹ�������״̬���:");
		pastureProcessingFactory.getMachinesState();
		
		System.out.println("-----------------------");
		System.out.println("״̬ģʽ����");
		Random random = new Random();
		int temprature = random.nextInt(20) + 10;
		int humidity = random.nextInt(25) + 10; 
		farmProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
		System.out.println("ũ���ӹ����������:");
		farmProcessingFactory.handle();
		temprature = random.nextInt(20) + 10;
		humidity = random.nextInt(25) + 10; 
		pastureProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
		System.out.println("�����ӹ����������:");
		farmProcessingFactory.handle();
		random = null;

		System.out.println("-----------------------");
		System.out.println("ģ��ģʽ����");
		farmProcessingFactory.execute();
		pastureProcessingFactory.execute();
	}
}
