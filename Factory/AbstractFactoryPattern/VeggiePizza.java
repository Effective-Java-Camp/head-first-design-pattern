package main.Factory.AbstractFactoryPattern;

public class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;

	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	void prepare() {
		System.out.println("Prepare");
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		System.out.println(dough + "\n" + sauce);
	}
}

