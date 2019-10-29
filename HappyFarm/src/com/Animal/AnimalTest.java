public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("-------------Factory Text-------------");
        Animal cat = FactoryDemo.run("Cat");
        Animal sheep = FactoryDemo.run("Sheep");
        Animal chicken = FactoryDemo.run("Chicken");



        System.out.println("-------------Strategy Text-------------");
        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);



        System.out.println("-------------Observer Text-------------");
        AnimalMonitor monitor = new AnimalMonitor();

        new WarningLight(monitor);
        new Telegraph(monitor);
        new Telephone(monitor);
 
        monitor.animalRunAway(chicken);



        System.out.println("-------------Bridge Text-------------");
        
    }
}
