package Animal.Observer;

public class Telephone extends Observer{
 
    public Telephone(AnimalMonitor monitor){
        this.monitor = monitor;
        this.monitor.attach(this);
    }
 
    @Override
    public void update() {
        System.out.println("Automatical telephone! One " + monitor.getType() 
        + " (id: " + monitor.getId() + ") has run away from your pasture!"); 
   }
}