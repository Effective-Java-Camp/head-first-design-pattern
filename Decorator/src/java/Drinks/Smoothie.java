package Drinks;

import Base.Beverage;

public class Smoothie extends Beverage {
    @Override
    public Integer cost() {
        return super.cost() + 4000;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "Smoothie ";
    }
}
