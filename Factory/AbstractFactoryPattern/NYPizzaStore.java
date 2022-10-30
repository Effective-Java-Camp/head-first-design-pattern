package main.Factory.AbstractFactoryPattern;

public class NYPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
			new NYPizzaIngredientFactory();

		if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");

		} else {
			return null;
		}
		return pizza;
	}
}

