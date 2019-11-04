package com.processing;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import com.shop.repository.*;
import com.shop.employee.*;

public class FarmProcessingFactory extends Produce implements AbstractProcessingFactory {

	//Machines List
	public List<Machine> machines;
	//factory's environment
	private Environment environment;
	
	public FarmProcessingFactory() {
		machines = new ArrayList<>();
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
		System.out.println("check machines' state̬");
		int size = machines.size();
		Random random = new Random();
		int index = random.nextInt(size);
		machines.get(index).setState(1);

		for(int i = 0;i<size;i++) {
			int state = machines.get(i).getMachineState();
			System.out.println("NO." + i + "machine's state:" + state);
			if(state == 1) {
				System.out.println("remove NO." + i + "machine");
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
		String ingredient = "Wheat";
		System.out.println("Successfully access the ingredient: " + ingredient);
		return ingredient;
	}

	@Override
	String processIngredient(String ingredient){
		return "Flour";
	}

	@Override
	void storeProduct(String product){
		RepositoryProxy repository = RepositoryProxy.Instance();
		repository.add(Flour.class, 1);
		System.out.println("Successfully produce and store the product: " + product);
	}

	@Override
	public void doProcess(Request request, Response response, FactoryChain chain) {
		switch (request.getRequest()) {
			case "Wheat":
				int wheatNum=request.getRepositoryProxy().checkItemNum(Wheat.class);
				int reqNum = request.getNum();
				if(wheatNum>reqNum) {
					request.getRepositoryProxy().ask(Wheat.class, reqNum);
					System.out.println(reqNum+ " Flour Produced.");/////////
					request.getRepositoryProxy().add(Flour.class,reqNum );
				}
				else {
					System.out.println("Not enough wheat.");///////
				}
			case "Eggcake":
				int flourNum=request.getRepositoryProxy().checkItemNum(Flour.class);
				int eggNum = request.getRepositoryProxy().checkItemNum(Egg.class);
				int reqNum1 = request.getNum();
				if(flourNum>reqNum1) {
					if(2*eggNum>reqNum1) {
						request.getRepositoryProxy().ask(Flour.class, reqNum1);
						request.getRepositoryProxy().ask(Egg.class, 2*reqNum1);
//						System.out.println(reqNum+ " EggCake Produced.");
						request.getRepositoryProxy().add(EggCake.class,reqNum1 );
					}
					else {
						System.out.println("Not enough eggs.");//////��������
					}
				}else {
					System.out.println("Not enough flour.");/////��۲���
				}
		}
		chain.doProcess(request, response, chain);
	}
}
