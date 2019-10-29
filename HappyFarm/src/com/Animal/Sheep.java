package Animal;

public class Sheep extends Animal {
    public int wool;
    public static String product = "Wool";

    public Sheep(int id) {
        this.id = id;
        this.hungryPoint = 1;
        this.happyPoint = 2;
        this.food = "Grass";
        this.type = "Sheep";
        this.wool = 8;
    }
}