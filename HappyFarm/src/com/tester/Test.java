package com.tester;

import com.pasture.Adapter.GrassEat;
import com.pasture.Animal;
import com.pasture.Bridge.*;
import com.pasture.Decorator.BlueWoolDecorator;
import com.pasture.Decorator.GreenWoolDecorator;
import com.pasture.Decorator.RedWoolDecorator;
import com.pasture.Decorator.Wool;
import com.pasture.Facade.AnimalPooMaker;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Interpreter.Expression;
import com.pasture.Interpreter.Interpreter;
import com.pasture.Observer.AnimalMonitor;
import com.pasture.Observer.Telegraph;
import com.pasture.Observer.Telephone;
import com.pasture.Observer.WarningLight;
import com.pasture.Sheep;
import com.pasture.Strategy.Fight;
import com.pasture.Strategy.Interaction;
import com.pasture.Strategy.Joke;
import com.pasture.Strategy.Sing;
import com.processing.*;
import com.processing.FactoryChain;
import com.shop.employee.*;
import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;
import com.shop.order.singleton.OrderSummary;
import com.shop.repository.RepositoryProxy;
import com.shop.store.SingleStore;
import com.farm.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {
    public static  void main(String[] args) {

        System.out.println("\n\n----------Repository Proxy Singleton Test ----------");
        System.out.println("Firstly get RepositoryProxy Instance.");
        RepositoryProxy.Instance();
        System.out.println("Secondly get RepositoryProxy Instance.");
        RepositoryProxy.Instance();

        System.out.println("\n\n---------- RepositoryProxy Proxy Test ----------");
        System.out.println("Test: Add Corn 100.");
        RepositoryProxy.Instance().add(CornSeed.class, 100);
        System.out.println("Test: Add seeds and fertilizers.");
        RepositoryProxy.Instance().add(CornSeed.class, 100);
        RepositoryProxy.Instance().add(PotatoSeed.class, 100);
        RepositoryProxy.Instance().add(WheatSeed.class, 100);
        RepositoryProxy.Instance().add(ChemicalFertilizer.class, 100);
        RepositoryProxy.Instance().add(OrganicFertilizer.class, 100);
        System.out.println("Test: Ask to consume Corn 150.");
        RepositoryProxy.Instance().ask(Corn.class, 150);
        System.out.println("Test: Ask to consume Corn 100.");
        RepositoryProxy.Instance().ask(Corn.class, 100);


        System.out.println("\n\n--------------------------------------");
        System.out.println("---------------Farm Test--------------");
        System.out.println("--------------------------------------");

        System.out.println("\n\n-------------Singleton Test-------------");
        System.out.println("To get the only instance of FarmManager.");

        FarmManager fm=FarmManager.getInstance();
        System.out.println("\nInit FarmManager.");
        System.out.println();

        System.out.println("\n\n-------------Mediator Test-------------");
        System.out.println("The FarmManager is the Mediator for others to manage the farm.");

        System.out.println("\nGet the reference of the instance of FarmManager.");


        System.out.println("\n\n-------------Composite Test-------------");
        System.out.println("The FarmManager is the composited by FieldManager and StockManager, while the list of objects of Field class form the FieldManager and Plant class forms the Field class.");


        System.out.println("\n\n-------------Memento Test-------------");

        System.out.println("\nSave the status at the beginning.");
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class);
        fm.seeding(CornSeed.class);
        System.out.println("Save the second status.");
        fm.saveFieldStatus();
        fm.seeding(WheatSeed.class);
        fm.seeding(WheatSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        System.out.println("Restore the second status, by just destroying all the plants planted after that.");
        fm.restore(1);
        System.out.println("Restore the first status");
        fm.restore(0);

        System.out.println("\n\n-------------Proxy Test-------------");
        System.out.println("FieldManager is the proxy when FarmManager invoking seeding(), giveFertilizer(), or harvest().");
        System.out.println("It tries to add or delete plant to the field.");
        System.out.println("and StockManager is the proxy of FarmManager to operate on repository.");
        System.out.println();

        fm.seeding(PotatoSeed.class);
        fm.giveFertilizer(0, OrganicFertilizer.class);
        fm.giveFertilizer(0, OrganicFertilizer.class);
        System.out.println("\n\n-------------Flyweight Test-----------");
        System.out.println("Fertilizers are using flyweight pattern which generate only one instance for each type of fertilizer.");
        fm.giveFertilizer(0, OrganicFertilizer.class);
        fm.harvest(0);

        System.out.println("\n\n-------------Factory Method Test-------------");
        System.out.println("PlantFactory class would produce corresponding plant according to the input class of seed.");
        fm.seeding(CornSeed.class, 10);
        fm.seeding(PotatoSeed.class, 11);
        fm.seeding(WheatSeed.class, 12);
        fm.showAllPlants();



        System.out.println("\n\n-------------Command Test-------------");
        System.out.println("The harvest() function would send a AddItemCommand to add a corresponding product after successfully harvesting.");
        fm.harvest(2);
        System.out.println("The seeding() function would send a QueryItemCommand to check the num of the seeds in repository, and send a DelItemCommand to subtract one if have planted the seed.");
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 51);
        fm.showAllPlants();

        System.out.println("\n\n--------------------------------------");
        System.out.println("-------------Pasture Test-------------");
        System.out.println("--------------------------------------");
        AnimalFactory animalFactory = new AnimalFactory();
        System.out.println("\n\n-------------Factory Test-------------");
        Animal cat = animalFactory.run("Cat");
        Animal sheep = animalFactory.run("Sheep");
        Animal chicken = animalFactory.run("Chicken");



        System.out.println("\n\n-------------Strategy Test-------------");
        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);



        System.out.println("\n\n-------------Observer Test-------------");
        AnimalMonitor monitor = new AnimalMonitor();

        new WarningLight(monitor);
        new Telegraph(monitor);
        new Telephone(monitor);

        monitor.animalRunAway(chicken);



        System.out.println("\n\n-------------Bridge Test-------------");
        System.out.println("Let the cat to yell 3 times..");
        AnimalYell catYell = new CatYell();
        YellTimes yellThreeTimes = new YellThreeTimes();
        catYell.setYellTimes(yellThreeTimes);
        catYell.yell();

        System.out.println("Let the sheep to yell 2 times..");
        AnimalYell sheepYell = new SheepYell();
        YellTimes yellTwiceTimes = new YellTwiceTimes();
        sheepYell.setYellTimes(yellTwiceTimes);
        sheepYell.yell();



        System.out.println("\n\n-------------Decorator Test-------------");
        Animal sheep2 = animalFactory.run("Sheep");

        System.out.println("Start getting 3 normal wool from sheep (id: " + sheep.id + ").");
        Wool normalWool = ((Sheep) sheep).beSheared(3, "Normal");
        System.out.println("Now start dyeing...");
        System.out.println(
                new GreenWoolDecorator(
                        new BlueWoolDecorator(
                                new RedWoolDecorator(normalWool)
                        )
                ).getDescription()
        );

        System.out.println("\nStart getting 3 long wool from sheep (id: " + sheep2.id + ").");
        Wool longWool = ((Sheep) sheep2).beSheared(3, "Normal");
        System.out.println("Now start dyeing...");
        System.out.println(
                new RedWoolDecorator(
                        new BlueWoolDecorator(
                                new GreenWoolDecorator(longWool)
                        )
                ).getDescription()
        );


        System.out.println("\n\n-------------Adapter Test-------------");
        GrassEat grassEat = new GrassEat();
        //考虑一种食物够 一种食物不够的情况
        grassEat.eat("Grass", sheep);
        grassEat.eat("Normal", cat);
        grassEat.eat("Normal", chicken);



        System.out.println("\n\n-------------Facade Test-------------");
        AnimalPooMaker animalPooMaker = new AnimalPooMaker();
        animalPooMaker.pooForCat(2);
        animalPooMaker.pooForChicken(1);
        animalPooMaker.pooForSheep(1);



        System.out.println("\n\n-------------Interpreter Test-------------");
        Expression oneLivestock = Interpreter.getLivestockExpression();
        Expression allLivestock = Interpreter.getAllLivestockExpression();

        System.out.println("Chicken is livestock? " + oneLivestock.interpret("Chicken"));
        System.out.println("Sheep and chicken are all the livestock in pasture? "
                + allLivestock.interpret("Sheep Chicken"));

//        process test
        System.out.println("\n\n--------------------------------------");
        System.out.println("------------Processing Test-----------");
        System.out.println("--------------------------------------");
        System.out.println("\n\n-------------Abstract Factory Test-------------");
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for(int i = 0;i<15;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        farmProcessingFactory.handle();
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        pastureProcessingFactory.handle();

        System.out.println("\n\n-------------Observer/Prototype Test-------------");
        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();

        System.out.println("\n\n-------------State Test-------------");
        Random random = new Random();
        int temprature = random.nextInt(20) + 10;
        int humidity = random.nextInt(25) + 10;
        farmProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
        System.out.println("Check FarmProcessingFactory's Environment:");
        farmProcessingFactory.handle();
        temprature = random.nextInt(20) + 10;
        humidity = random.nextInt(25) + 10;
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
        System.out.println("Check PastureProcessingFactory's Environment:");
        farmProcessingFactory.handle();
        random = null;

        System.out.println("\n\n-------------Template Test-------------");
        farmProcessingFactory.execute();
        pastureProcessingFactory.execute();

        System.out.println("\n\n-------------Visitor Test-------------");
        System.out.println("No.0 Machine in FarmProcessingFactory is damaged");
        farmProcessingFactory.machines.get(0).setState(1);
        farmProcessingFactory.machines.get(0).accept(new MachineDisplayVisitor());
        System.out.println("No.13 Machine in PastureProcessingFactory is damaged");
        pastureProcessingFactory.machines.get(13).setState(1);
        pastureProcessingFactory.machines.get(13).accept(new MachineDisplayVisitor());

        System.out.println("\n\n-------------Responsibility Chain Test-------------");
        RepositoryProxy.Instance();
        RepositoryProxy.Instance().add(Chicken.class,50);
        RepositoryProxy.Instance().add(Wheat.class,50);
        RepositoryProxy.Instance().add(Egg.class,50);

        FactoryChain factoryChain = new FactoryChain();
        factoryChain.addFactory(farmProcessingFactory);
        factoryChain.addFactory(pastureProcessingFactory);
        //-----------PUT TWO FACTORIES INTO IT
        Request request1 = new Request();
        request1.setRequest("Flour");
        request1.setNum(20);
        request1.setRepositoryProxy(RepositoryProxy.Instance());
        Request request2 = new Request();
        request2.setRequest("Eggcake");
        request2.setNum(5);
        request2.setRepositoryProxy(RepositoryProxy.Instance());
        Request request3 = new Request();
        request3.setRequest("ChickenKebabs");
        request3.setNum(10);
        request3.setRepositoryProxy(RepositoryProxy.Instance());
        Response response = new Response();
        factoryChain.doProcess(request1, response, factoryChain);
        factoryChain.doProcess(request2, response, factoryChain);
        factoryChain.doProcess(request3, response, factoryChain);

//        shop test
        System.out.println("\n\n--------------------------------------");
        System.out.println("---------------Shop Test--------------");
        System.out.println("--------------------------------------");

        System.out.println("\n\n---------- SingleStore Singleton Test ----------");
        SingleStore store = SingleStore.getSingleStore();
        System.out.println("You have got a SingleStore!");

        System.out.println("\n\n---------- SingleStore strategy and observer Test ----------");
        RepositoryProxy.Instance().attach(store);
        System.out.println("The repository has attached the SingleStore!");
        RepositoryProxy.Instance().add(Egg.class, 9100);

        System.out.println("\nThe strategy is normalVIP, whose discount is " + store.getStrategy());
        System.out.println("The SingleStore has sold 1000 Eggs,whose initial price is " + new Egg().getprice() * 1000);
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 1000));
        Employee.createSaleOrder(Egg.class,1000);

        System.out.println("\nThe strategy is goldVIP, whose discount is " + store.getStrategy());
        System.out.println("The SingleStore has sold 4000 Eggs,whose price is " + new Egg().getprice() * 4000);
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 4000));
        Employee.createSaleOrder(Egg.class,4000);

        System.out.println("\nThe strategy is superVIP, whose discount is " + store.getStrategy());
        System.out.println("The SingleStore has sold 3000 Eggs,whose price is " + new Egg().getprice());
        System.out.println("The Eggs cost the customer " + store.useStrategy(new Egg().getprice() * 1000));
        Employee.createSaleOrder(Egg.class,1000);

        System.out.println("----------  Builder Test----------");
        System.out.println("Firstly,we will add some different goods in the repository");
        RepositoryProxy.Instance().add(Corn.class, 100);
        RepositoryProxy.Instance().add(Egg.class, 100);
        RepositoryProxy.Instance().add(Wheat.class, 100);
        System.out.println("Now we creat a new order with multiple goods");
        Map<Class,Integer> map=new HashMap<>();
        map.put(Egg.class,100);
        map.put(Corn.class,100);
        map.put(Wheat.class,100);
        Employee.createBuyOrder(map);

        System.out.println("\n\n---------- Order Factory Test ----------");
        System.out.println("Create order factory.");
        OrderFactory orderFactory = new OrderFactory();

        System.out.println("\n\n---------- Order Status Test ----------");
        System.out.println("Buy two kilogram corn.");
        Order order1 = orderFactory.getOrder("BUY");
        order1.createOrder(Corn.class, 2, 5.00);
        System.out.println("\nSale two kilogram corn.");
        Order order3 = orderFactory.getOrder("SALE");
        order3.createOrder(Corn.class, 2, 5.00);

        System.out.println("\n\n---------- Null Object Test ----------");
        System.out.println("Create wrong order");
        Order order2 = orderFactory.getOrder("SAL");
        order2.createOrder(Corn.class, 2, 5.00);

        System.out.println("\n\n---------- Summary Singleton Test ----------");
        System.out.println("Firstly get Summary Instance.");
        OrderSummary.getSummary().showAllItems();
    }
}
