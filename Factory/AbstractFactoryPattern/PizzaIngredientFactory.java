package main.Factory.AbstractFactoryPattern;

public interface PizzaIngredientFactory {

	public Dough createDough();
	public Sauce createSauce();
}
