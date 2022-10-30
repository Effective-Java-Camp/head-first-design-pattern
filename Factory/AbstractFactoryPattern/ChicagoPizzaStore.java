package main.Factory.AbstractFactoryPattern;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
			new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else {
			return null;
		}
		return pizza;
	}
}
