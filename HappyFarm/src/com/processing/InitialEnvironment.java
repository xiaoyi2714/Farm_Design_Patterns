package com.processing;
/**
 * ������ʼ����
 * @author linyi
 *
 */
public class InitialEnvironment extends Environment {

	public InitialEnvironment(int temperature, int humidity) {
		super(temperature, humidity);
	}

	@Override
	public void handle(AbstractProcessingFactory abstractProcessingFactory) {
		System.out.println("����Ŀǰʪ��Ϊ:"+getHumidity()+"%");
		System.out.println("����Ŀǰ�¶�Ϊ:"+getTemperature()+"��");
		if(getHumidity() > 30) {
			System.out.println("����ʪ�ȹ��ߣ��轵��ʪ��");
			setHumidity(15);
			System.out.println("����ʪ�Ƚ�����20%");
		}
		if(getTemperature() > 25) {
			System.out.println("�����¶ȹ��ߣ��轵���¶�");
			setTemperature(15);
			System.out.println("�����¶Ƚ�����20��");
		}
	}
}
