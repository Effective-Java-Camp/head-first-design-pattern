package Toppings;

import Base.Beverage;
import Base.Decorator;

public class Choco extends Decorator {
    private Beverage beverage;

    public Choco(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Integer cost() {
        return beverage.cost() + 500;
    }
    @Override
    public String getDescription(){
        return beverage.getDescription() + super.getDescription() + "Choco ";
    }
}