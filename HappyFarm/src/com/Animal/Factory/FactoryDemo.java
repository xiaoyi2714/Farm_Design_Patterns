package Animal.Factory;

public class FactoryDemo {
    public int id = 0;

    public Animal run(String type) {
        if (type.equals("Cat")){
            return new Cat(id);
            id = id + 1;
            System.out.println("Create a new cat!");
        } else if (type.equals("Sheep")) {
            return new Sheep(id);
            id = id + 1;
            System.out.println("Create a new sheep!");
        } else if (type.equals("Chicken")) {
            return new Chicken(id);
            id = id + 1;
            System.out.println("Create a new chicken!");
        } else {
            System.out.println("Wrong parameter!");
            return null;
        }
    }
}