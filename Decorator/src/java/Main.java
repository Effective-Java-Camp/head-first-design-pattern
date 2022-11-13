

import Base.Beverage;
import Drinks.*;
import Toppings.*;

public class Main {
    public static void main(String[] args){
        Beverage americano = new Americano();
        System.out.println(americano .getDescription() + "cost is : " + americano.cost());
        americano = new Shot(americano);
        System.out.println(americano .getDescription() + "cost is : " + americano.cost() + "\n");


        Beverage mintChoco = new MintChoco();
        System.out.println(mintChoco .getDescription() + "cost is : " + mintChoco.cost());
        mintChoco = new Choco(mintChoco);
        System.out.println(mintChoco .getDescription() + "cost is : " + mintChoco.cost());
        mintChoco = new Milk(mintChoco);
        System.out.println(mintChoco .getDescription() + "cost is : " + mintChoco.cost()+ "\n");


        Beverage latte = new Latte();
        System.out.println(latte.getDescription() + "cost is : " + latte.cost());
        latte = new Milk(latte);
        System.out.println(latte.getDescription() + "cost is : " + latte.cost());

    }
}