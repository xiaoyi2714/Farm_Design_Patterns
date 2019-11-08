package com.processing;

import java.util.LinkedList;

import java.util.List;
import java.util.Random;

import com.shop.employee.*;
import com.shop.repository.*;

public class PastureProcessingFactory extends Produce implements AbstractProcessingFactory  {
	
	//Machine List
	public List<Machine> machines;
	//Factory's Environment
	private Environment environment;
	
	public PastureProcessingFactory() {
		machines = new LinkedList<>();
	}

	@Override
	public void addMachine() {
		machines.add(new Machine());
	}

	@Override
	public void removeMachine(int index) {
		machines.remove(index);
	}

	@Override
	public void getMachinesState() {
		System.out.println("check machines' state");
		int size = machines.size();
		Random random = new Random();
		int index = random.nextInt(size);
		machines.get(index).setState(1);
		
		for(int i = 0;i<size;i++) {
			int state = machines.get(i).getMachineState();
			System.out.println("NO." + i + "machine's state:" + state);
			if(state == 1) {
				System.out.println("remove NO." + i + " machine");
				Machine machine = machines.get(i);
				machines.remove(i);
				try {
					machines.add(machine.clone());
					machine = null;
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				System.out.println("successfully added machine");
			}
		}
	}

	@Override
	public void handle() {
		if(environment == null) {
			System.out.println("please initialize factory's environment");
			return;
		}	
		environment.handle(this);
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	String getIngredient(){
		String ingredient = "Egg";
		System.out.println("Successfully access the ingredient: " + ingredient);
		return ingredient;
	}

	@Override
	String processIngredient(String ingredient){
		return "EggCake";
	}

	@Override
	void storeProduct(String product){
		RepositoryProxy repository = RepositoryProxy.Instance();
		repository.add(EggCake.class, 1);
		System.out.println("Successfully produce and store the product: " + product);
	}

	@Override
	public void doProcess(Request request, Response response, FactoryChain chain) {
		switch (request.getRequest()) {
			case "ChickenKebabs":
				int chickenNum=request.getRepositoryProxy().checkItemNum(Chicken.class);
				int reqNum = request.getNum();
				if(chickenNum>reqNum) {
					request.getRepositoryProxy().ask(Chicken.class, reqNum);
					System.out.println(reqNum+ " ChickenKebabs Produced.");/////////
					request.getRepositoryProxy().add(ChickenKebabs.class,reqNum );
				}
				else {
					System.out.println("Not enough chicken.");///////
				}
		}
		chain.doProcess(request, response, chain);
	}
}
