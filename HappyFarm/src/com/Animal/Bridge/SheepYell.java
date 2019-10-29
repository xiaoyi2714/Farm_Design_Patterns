public class SheepYell implements YellAPI {
    @Override
    public void animalYell(int time) {
        for (int i = 0; i < time; i++) {
            System.out.println("miemiemieeeeeemiemieeeee");
        }
    }
}