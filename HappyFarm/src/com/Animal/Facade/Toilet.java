public class Toilet {
    private AnimalPoo catPoo;
    private AnimalPoo chickenPoo;
    private AnimalPoo sheepPoo;
 
    public Toilet() {
        catPoo = new CatPoo();
        chickenPoo = new ChickenPoo();
        sheepPoo = new SheepPoo();
    }
 
    public void pooForCat(int quantity) {
        catPoo.poo(quantity);
    }
    public void pooForChicken(int quantity) {
        chickenPoo.poo(quantity);
    }
    public void pooForSheep(int quantity) {
        chickenPoo.poo(quantity);
    }
}