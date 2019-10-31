package processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 农产品加工厂(State的环境类)
 * @author linyi
 *
 */
public class FarmProcessingFactory implements AbstractProcessingFactory extends Produce {

	//机器List
	public List<Machine> machines;
	//工厂状态
	public Environment environment;
	
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
		System.out.println("检查所有机器状态");
		int size = machines.size();
		Random random = new Random();
		//产生随机数模拟机器损坏的情况
		int index = random.nextInt(size);
		machines.get(index).setState(1);
		
		for(int i = 0;i<size;i++) {
			int state = machines.get(i).getMachineState();
			System.out.println("第" + i + "号机器状态:" + state);
			//机器损坏
			if(state == 1) {
				System.out.println("移除第" + i + "号机器");
				Machine machine = machines.get(i);
				machines.remove(i);
				try {
					machines.add(machine.clone());
					machine = null;
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				System.out.println("添加机器成功");
			}
		}
	}

	@Override
	public void handle() {
		if(environment == null) {
			System.out.println("请指定工厂的环境");
			return;
		}
		environment.handle(this);
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	int getIngredient(){
		Random random = new Random();
		ingredient = random.nextInt(3);
		Warehouse warehouse = Warehouse.getInstance();
		warehouse.use(ingredient);
		System.out.println("取出原材料" + ingredient);
		return ingredient;
	}

	@Override
	int processIngredient(int ingredient){
		return ingredient;
	}

	@Override
	int storeProduct(int product){
		Warehouse warehouse = Warehouse.getInstance();
		warehouse.store(product);
		System.out.println("生产并储存商品" + product);
	}
}
