package com.processing;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import com.shop.repository.*;
import com.shop.employee.*;

/**
 * ũ��Ʒ�ӹ���(State�Ļ�����)
 * @author linyi
 *
 */
public class FarmProcessingFactory extends Produce implements AbstractProcessingFactory {

	//����List
	private List<Machine> machines;
	//����״̬
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
		String ingredient = "小麦";
		System.out.println("ȡ��ԭ����" + ingredient);
		return ingredient;
	}

	@Override
	String processIngredient(String ingredient){
		return "面粉";
	}

	@Override
	void storeProduct(String product){
		RepositoryProxy repository = RepositoryProxy.Instance();
		repository.add(Flour.class, 1);
		System.out.println("������������Ʒ" + product);
	}
	
	@Override
	public void doProcess(Request request, Response response, FactoryChain chain) {
		switch (request.getRequest()) {
		case "���": 
			int wheatnum=request.getRepositoryProxy().checkItemNum(Wheat.class);
			int reqnum = request.getNum();
			if(wheatnum>reqnum) {
				request.getRepositoryProxy().ask(Wheat.class, reqnum);
				System.out.println("  ");/////////
				request.getRepositoryProxy().add(Flour.class,reqnum );
			}
			else {
				System.out.println("  ");///////
			}
		case "������": 
			int flournum=request.getRepositoryProxy().checkItemNum(Flour.class);
			int eggnum = request.getRepositoryProxy().checkItemNum(Egg.class);
			int reqnum1 = request.getNum();
			if(flournum>reqnum1) {
				if(2*eggnum>reqnum1) {
					request.getRepositoryProxy().ask(Flour.class, reqnum1);
					request.getRepositoryProxy().ask(Egg.class, 2*reqnum1);
					System.out.println("  ");
					request.getRepositoryProxy().add(EggCake.class,reqnum1 );
				}
				else {
					System.out.println("  ");//////��������
				}
			}else {
				System.out.println("  ");/////��۲���
			}
		}
		

	}
}
