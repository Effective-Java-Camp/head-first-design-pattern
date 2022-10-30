package main.Factory.FactoryMethodPattern;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else {
			return null;
		}
	}
}