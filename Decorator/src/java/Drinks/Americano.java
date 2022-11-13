package Drinks;

import Base.Beverage;

public class Americano extends Beverage {
    @Override
    public Integer cost() {
        return super.cost() + 2500;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "Americano ";
    }
}