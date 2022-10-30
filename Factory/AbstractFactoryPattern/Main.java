package main.Factory.AbstractFactoryPattern;

public class Main {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		Pizza pizza = nyStore.orderPizza("veggie");

		pizza = chicagoStore.orderPizza("cheese");
	}
}