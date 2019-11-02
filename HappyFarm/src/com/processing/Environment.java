package com.processing;

abstract public class Environment {

	private int temperature;
	private int humidity;
	
	public Environment(int temperature, int humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	//invoke factory's handle()
	public abstract void handle(AbstractProcessingFactory abstractProcessingFactory);

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
}
