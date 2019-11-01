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
        FactoryDemo factoryDemo = new FactoryDemo();
        System.out.println("-------------Factory Text-------------");
        Animal cat = factoryDemo.run("Cat");
        Animal sheep = factoryDemo.run("Sheep");
        Animal chicken = factoryDemo.run("Chicken");



        System.out.println("-------------Strategy Text-------------");
        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);



        System.out.println("-------------Observer Text-------------");
        AnimalMonitor monitor = new AnimalMonitor();

        new WarningLight(monitor);
        new Telegraph(monitor);
        new Telephone(monitor);
 
        monitor.animalRunAway(chicken);



        System.out.println("-------------Bridge Text-------------");
        System.out.println("Let the cat to yell 3 times..");
        AnimalYell catYell = new AnimalYell(new CatYell());
        catYell.yell(3);

        System.out.println("Let the sheep to yell 2 times..");
        AnimalYell sheepYell = new AnimalYell(new SheepYell());
        sheepYell.yell(2);



        System.out.println("-------------Decorator Text-------------");
        Animal sheep2 = factoryDemo.run("Sheep");
        Animal sheep3 = factoryDemo.run("Sheep");

        Wool wool = new NormalWool();
        WoolDecorator redWool = new RedWoolDecorator();
        WoolDecorator blueWool = new BlueWoolDecorator();

        System.out.println("Get 3 normal wool from sheep1..");
        wool.shearing((Sheep)sheep, 3);
        System.out.println("Get 2 red wool from sheep2..");
        redWool.shearing((Sheep)sheep2, 2);
        System.out.println("Get 4 blue wool from sheep3..");
        blueWool.shearing((Sheep)sheep3, 4);



        System.out.println("-------------Adapter Text-------------");
        NormalEat normalEat = new NormalEat();
        //考虑一种食物够 一种食物不够的情况
        normalEat.eat(cat);
        normalEat.eat(chicken);
        normalEat.eat(sheep);



        System.out.println("-------------Facade Text-------------");
        Toilet toilet = new Toilet();
        toilet.pooForCat(2);
        toilet.pooForChicken(1);



        System.out.println("-------------Interpreter Text-------------");
        Expression oneLivestock = Interpreter.getLivestockExpression();
        Expression allLivestock = Interpreter.getAllLivestockExpression();

        System.out.println("Chicken is livestock? " + oneLivestock.interpret("Chicken"));
        System.out.println("Sheep and chicken are all the livestock in pasture? "
                + allLivestock.interpret("Sheep Chicken"));
    }
}
