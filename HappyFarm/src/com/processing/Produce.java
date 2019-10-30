package com.processing;

public abstract class Produce {
	
    abstract String getIngredient();
    abstract String processIngredient(String ingredient);
    abstract void storeProduct(String product);

    //ģ�巽��
    public final void execute() {
        String ingredient = getIngredient();
        String product = processIngredient(ingredient);
        storeProduct(product);
    }
}