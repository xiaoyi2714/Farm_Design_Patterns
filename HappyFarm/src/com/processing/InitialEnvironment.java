package com.processing;

public class InitialEnvironment extends Environment {

	public InitialEnvironment(int temperature, int humidity) {
		super(temperature, humidity);
	}

	@Override
	public void handle(AbstractProcessingFactory abstractProcessingFactory) {
		System.out.println("current humidity:"+getHumidity()+"%");
		System.out.println("current temperature:"+getTemperature()+"℃");
		if(getHumidity() > 30) {
			System.out.println("humidity is too high");
			setHumidity(15);
			System.out.println("humidity decreased to 15%");
		}
		if(getTemperature() > 25) {
			System.out.println("temperature is too high");
			setTemperature(15);
			System.out.println("temperature decreased to 15%℃");
		}
	}
}
