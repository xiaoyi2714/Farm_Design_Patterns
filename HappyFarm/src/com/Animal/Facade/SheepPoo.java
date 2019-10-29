package Animal.Facade;

public class SheepPoo implements AnimalPoo {
 
    @Override
    public void poo(int quantity) {
        // todo 加入粪便
        System.out.println("The sheep poo " + quantity + " sheep stool.");
    }
}