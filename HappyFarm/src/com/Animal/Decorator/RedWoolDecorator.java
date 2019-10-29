package Animal.Decorator;

public class RedWoolDecorator extends WoolDecorator {
 
    public RedWoolDecorator() {
    }

    @Override
    public void shearing(Sheep sheep, int quantity) {
        NormalWool normalWool = new NormalWool();
        normalWool.shearing(sheep, quantity);         
        dyeRedWool(quantity);
        //加入仓库
    }
 
    private void dyeRedWool(int quantity){
        System.out.println("Having dyed " quantity + "wool into red color successfully!");
    }
}