package com.processing;
/**
 * 工厂初始环境
 * @author linyi
 *
 */
public class InitialEnvironment extends Environment {

	public InitialEnvironment(int temperature, int humidity) {
		super(temperature, humidity);
	}

	@Override
	public void handle(AbstractProcessingFactory abstractProcessingFactory) {
		System.out.println("工厂目前湿度为:"+getHumidity()+"%");
		System.out.println("工厂目前温度为:"+getTemperature()+"℃");
		if(getHumidity() > 30) {
			System.out.println("工厂湿度过高，需降低湿度");
			setHumidity(15);
			System.out.println("工厂湿度降低至20%");
		}
		if(getTemperature() > 25) {
			System.out.println("工厂温度过高，需降低温度");
			setTemperature(15);
			System.out.println("工厂温度降低至20℃");
		}
	}
}
