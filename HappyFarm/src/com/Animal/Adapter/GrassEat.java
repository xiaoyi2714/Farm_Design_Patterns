public class GrassEat implements AnimalEat {
 
   @Override
   public void eat(Animal animal) {    
         //TODO 把item的东西移动过来
         int foodToEat = animal.hungryPoint;
         System.out.println("There are infinity Grass in store," 
         + " and the " animal.name + " needs " + foodNeeded + " Grass.");

         animal.hungryPoint = animal.hungryPoint - foodToEat;
         System.out.println("Animal (id: " + animal.id + ") have eaten " 
         + foodToEat + " " + animal.food + "!");
   }   
}