package processing;

public abstract class Produce {
    abstract int getIngredient();
    abstract int processIngredient(int ingredient);
    abstract void storeProduct(int product);

    //模板方法
    public final void execute() {
        int ingredient = getIngredient();
        int product = processIngredient(ingredient);
        storeProduct(product);
    }
}