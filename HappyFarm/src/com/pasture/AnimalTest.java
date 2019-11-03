package com.pasture;

import com.pasture.Adapter.*;
import com.pasture.Bridge.*;
import com.pasture.Decorator.*;
import com.pasture.Facade.*;
import com.pasture.Factory.*;
import com.pasture.Observer.*;
import com.pasture.Strategy.*;
import com.pasture.Interpreter.*;

public class AnimalTest {
    public static  void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        System.out.println("-------------Factory Text-------------");
        Animal cat = animalFactory.run("Cat");
        Animal sheep = animalFactory.run("Sheep");
        Animal chicken = animalFactory.run("Chicken");



        System.out.println("\n\n-------------Strategy Text-------------");
        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);



        System.out.println("\n\n-------------Observer Text-------------");
        AnimalMonitor monitor = new AnimalMonitor();

        new WarningLight(monitor);
        new Telegraph(monitor);
        new Telephone(monitor);
 
        monitor.animalRunAway(chicken);



        System.out.println("\n\n-------------Bridge Text-------------");
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



        System.out.println("\n\n-------------Decorator Text-------------");
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


        System.out.println("\n\n-------------Adapter Text-------------");
        GrassEat grassEat = new GrassEat();
        //考虑一种食物够 一种食物不够的情况
        grassEat.eat("Grass", sheep);
        grassEat.eat("Normal", cat);
        grassEat.eat("Normal", chicken);



        System.out.println("\n\n-------------Facade Text-------------");
        AnimalPooMaker animalPooMaker = new AnimalPooMaker();
        animalPooMaker.pooForCat(2);
        animalPooMaker.pooForChicken(1);
        animalPooMaker.pooForSheep(1);



        System.out.println("\n\n-------------Interpreter Text-------------");
        Expression oneLivestock = Interpreter.getLivestockExpression();
        Expression allLivestock = Interpreter.getAllLivestockExpression();

        System.out.println("Chicken is livestock? " + oneLivestock.interpret("Chicken"));
        System.out.println("Sheep and chicken are all the livestock in pasture? "
                + allLivestock.interpret("Sheep Chicken"));
    }
}
