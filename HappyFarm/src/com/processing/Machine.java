package com.processing;
/**
 * �ӹ����еĻ�����(Observer)
 * @author linyi
 *
 */
public class Machine implements Cloneable, Observer {

	//����״̬
	private int state;
	
	//Prototype�Ŀ�¡����
	public Machine clone() throws CloneNotSupportedException {
		this.state = 0;
		System.out.println("�������Ƴɹ�");
		return (Machine) super.clone();
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int getMachineState() {
		return this.state;
	}
}
