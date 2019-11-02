package com.processing;

import java.util.Random;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("-------------Abstract Factory Test-------------");
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

        System.out.println("-------------Observer/Prototype Test-------------");
        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();

        System.out.println("-------------State Test-------------");
        Random random = new Radnom();
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

        System.out.println("-------------Template Test-------------");
        farmProcessingFactory.execute();
        pastureProcessingFactory.execute();

        System.out.println("-------------Visitor Text-------------");
        System.out.println("No.0 Machine in FarmProcessingFactory is damaged");
        farmProcessingFactory.machines.get(0).setState(1);
        farmProcessingFactory.machines.get(0).accept(new MachineDisplayVisitor());
        System.out.println("No.13 Machine in PastureProcessingFactory is damaged");
        pastureProcessingFactory.machines.get(13).setState(1);
        pastureProcessingFactory.machines.get(13).accept(new MachineDisplayVisitor());
    }
}