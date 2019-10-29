package Animal.Strategy;

public class Interaction {
    private Strategy strategy;
 
    public Interaction(Strategy strategy){
        this.strategy = strategy;
    }
 
    public int executeInteraction(Animal animal1, Animal animal2){
        return strategy.doOperation(animal1, animal2);
    }
}