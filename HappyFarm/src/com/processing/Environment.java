package com.processing;
/**
 * ����״̬��
 * @author linyi
 *
 */
abstract public class Environment {

	//�����е��¶�
	private int temperature;
	//�����е�ʪ��
	private int humidity;
	
	public Environment(int temperature, int humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	//���ù�����Handle����
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
