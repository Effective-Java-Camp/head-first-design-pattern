package Base;
public class Decorator extends Beverage{
    @Override
    public String getDescription(){
        return "Add Topping: ";
    }
}