public class CatPoo implements AnimalPoo {
 
    @Override
    public void poo(int quantity) {
        // todo 加入粪便
        System.out.println("The cat poo " + quantity + " cat stool.");
    }
}