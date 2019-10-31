package processing;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private static int[] ingredientList = new int[3];
    private static int[] productList = new int[3];

    private Warehouse() { }

    public static Warehouse getInstance() {
        return instance;
    }

    public void use(int number){
        ingredientList[number] = ingredientList[number] - 1;
    }

    public void store(int number){
        productList[number] = productList[number] + 1;
    }
}