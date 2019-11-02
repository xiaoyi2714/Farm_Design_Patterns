package com.processing;

public class Machine implements Cloneable, Observer, MachineVisited {

	//机器状态
	private int state;
	
	//Prototype的克隆函数
	public Machine clone() throws CloneNotSupportedException {
		this.state = 0;
		System.out.println("successfully cloned machine");
		return (Machine) super.clone();
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int getMachineState() {
		return this.state;
	}

	@Override
	public void accept(MachineVisitor visitor) {
		visitor.visit(this);
	}
}
