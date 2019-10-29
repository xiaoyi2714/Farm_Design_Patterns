package com.tester;
import com.shop.employee.*;
import com.shop.order.Corn;
import com.shop.repository.RepositoryProxy;
import com.shop.store.SingleStore;
import com.farm.*;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleStore store = SingleStore.getSingleStore();
		RepositoryProxy.Instance().attach(store);

		Employee.createBuyOrder(CornSeed.class, 1);
		Employee.createBuyOrder(PotatoSeed.class, 10);
		Employee.createBuyOrder(WheatSeed.class, 10);
		Employee.createBuyOrder(ChemicalFertilizer.class, 50);
		Employee.createBuyOrder(OrganicFertilizer.class, 2);

		RepositoryProxy.Instance().showAllItems();

		FarmManager fm=FarmManager.getInstance();
		fm.seeding(PotatoSeed.class);
		fm.seeding(PotatoSeed.class, 0);
		fm.seeding(PotatoSeed.class);
		fm.seeding(CornSeed.class);
		fm.seeding(WheatSeed.class);
		fm.seeding(WheatSeed.class);
		fm.seeding(CornSeed.class);
		fm.showAllPlants();
		fm.showAllItems();
		fm.giveFertilizer(0, OrganicFertilizer.class);
		fm.giveFertilizer(0, OrganicFertilizer.class);
		fm.giveFertilizer(0, OrganicFertilizer.class);
		fm.showAllPlants();
		fm.showAllItems();
		fm.harvest(0);
		fm.showAllPlants();
		fm.giveFertilizer(2, OrganicFertilizer.class);
		fm.giveFertilizer(2, ChemicalFertilizer.class);
		fm.giveFertilizer(2, ChemicalFertilizer.class);
		fm.harvest(2);
		fm.giveFertilizer(2, ChemicalFertilizer.class);
		fm.giveFertilizer(2, ChemicalFertilizer.class);
		fm.harvest(2);
		fm.giveFertilizer(2, ChemicalFertilizer.class);
		fm.harvest(3);
		fm.showAllPlants();
		fm.seeding(PotatoSeed.class,0);
		fm.seeding(PotatoSeed.class);
		fm.showAllPlants();

	}

}
