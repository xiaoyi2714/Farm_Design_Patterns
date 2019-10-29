package Animal.Bridge;

public class CatYell implements YellAPI {
    @Override
    public void animalYell(int time) {
        for (int i = 0; i < time; i++) {
            System.out.println("miaomiaomaiaooooooomiaomiaooo");
        }
    }
}