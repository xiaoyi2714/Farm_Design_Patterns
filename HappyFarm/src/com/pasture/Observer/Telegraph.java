package com.pasture.Observer;

public class Telegraph extends Observer{
 
    public Telegraph(AnimalMonitor monitor){
        this.monitor = monitor;
        this.monitor.attach(this);
    }
 
    @Override
    public void update() {
        System.out.println("Telegraph from telegraph machine 1! One " + monitor.getType() 
        + " (id: " + monitor.getId() + ") has run away from com.pasture! Please help searching!");
   }
}