package com.pasture.Observer;

import com.pasture.Animal;

import java.util.ArrayList;
import java.util.List;
 
public class AnimalMonitor {
    private List<Observer> observers = new ArrayList<Observer>();
    private int id;
    private String type;
 
    public void animalRunAway(Animal animal) {
        id = animal.id;
        type = animal.type;
        notifyAllObservers();
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }  

    public int getId() {
        return id;
    }
    
    public String getType() {
        return type;
    }

    public void attach(Observer observer){
      observers.add(observer);      
    }
}