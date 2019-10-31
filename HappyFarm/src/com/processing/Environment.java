package processing;
/**
 * 抽象状态类
 * @author linyi
 *
 */
abstract public class Environment {

	//工厂中的温度
	private int temperature;
	//工厂中的湿度
	private int humidity;
	
	public Environment(int temperature, int humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	//调用工厂的Handle函数
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
