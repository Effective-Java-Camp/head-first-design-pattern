package main.Factory.SimpleFactoryPattern;

public class PizzaStore{
	SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory){
		this.factory = factory;
	}

	Pizza orderPizza(String type){
		Pizza pizza;

		pizza = factory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}