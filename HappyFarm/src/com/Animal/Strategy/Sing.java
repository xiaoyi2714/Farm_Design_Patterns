public class Sing implements Strategy{
    @Override
    public void doOperation(Animal animal1, Animal animal2) {
        animal1.happyPoint = animal1.happyPoint + 2;
        animal2.happyPoint = animal2.happyPoint + 1;
        System.out.println(animal1.type + "(id: " + animal1.id + ") sing to " 
        + animal2.type + "(id:" + animal2.id + ")!");
    }
}