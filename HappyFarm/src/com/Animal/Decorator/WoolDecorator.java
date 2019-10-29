public abstract class WoolDecorator implements Wool {
    protected Sheep sheep;
    protected int quantity;
 
    public WoolDecorator(Sheep sheep, int quantity){
        this.sheep = sheep;
        this.quantity = quantity;
    }
    
    public void shearing(){
        System.out.println("Error: Do not implement specific decorator!");
    }
}