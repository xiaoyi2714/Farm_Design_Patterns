package com.pasture.Observer;

public class WarningLight extends Observer{
 
    public WarningLight(AnimalMonitor monitor){
        this.monitor = monitor;
        this.monitor.attach(this);
    }
 
    @Override
    public void update() {
        System.out.println("Warning light! One " + monitor.getType() 
        + " (id: " + monitor.getId() + ") has run away!"); 
   }
}