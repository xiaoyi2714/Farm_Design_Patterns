package com.processing;

import java.util.LinkedList;

import java.util.List;
import java.util.Random;

import com.shop.employee.*;
import com.shop.repository.*;

/**
 * ����Ʒ�ӹ���
 * @author linyi
 *
 */
public class PastureProcessingFactory extends Produce implements AbstractProcessingFactory  {
	
	//����List
	private List<Machine> machines;
	//����״̬״̬
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
		System.out.println("������л���״̬");
		int size = machines.size();
		Random random = new Random();
		//���������ģ������𻵵����
		int index = random.nextInt(size);
		machines.get(index).setState(1);
		
		for(int i = 0;i<size;i++) {
			int state = machines.get(i).getMachineState();
			System.out.println("��" + i + "�Ż���״̬:" + state);
			//������
			if(state == 1) {
				System.out.println("�Ƴ���" + i + "�Ż���");
				Machine machine = machines.get(i);
				machines.remove(i);
				try {
					machines.add(machine.clone());
					machine = null;
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				System.out.println("���ӻ����ɹ�");
			}
		}
	}

	@Override
	public void handle() {
		if(environment == null) {
			System.out.println("��ָ�������Ļ���");
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
		String ingredient = "鸡蛋";
		System.out.println("ȡ��ԭ����" + ingredient);
		return ingredient;
	}

	@Override
	String processIngredient(String ingredient){
		return "蛋糕";
	}

	@Override
	void storeProduct(String product){
		RepositoryProxy repository = RepositoryProxy.Instance();
		repository.add(EggCake.class, 1);
		System.out.println("������������Ʒ" + product);
	}

	@Override
	public void doProcess(Request request, Response response, FactoryChain chain) {
		switch (request.getRequest()) {
			case "���⴮":
				int chickennum=request.getRepositoryProxy().checkItemNum(Chicken.class);
				int reqnum = request.getNum();
				if(chickennum>reqnum) {
					request.getRepositoryProxy().ask(Chicken.class, reqnum);
					System.out.println("  ");/////////
					request.getRepositoryProxy().add(ChickenKebabs.class,reqnum );
				}
				else {
					System.out.println("  ");///////
				}
		}
		chain.doProcess(request, response, chain);
	}
}
