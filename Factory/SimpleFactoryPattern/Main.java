package main.Factory.SimpleFactoryPattern;

public class Main {
	public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore pizzaStore = new PizzaStore(factory);

		System.out.println("<CheesePizza>");
		Pizza cheesePizza = pizzaStore.orderPizza("cheese");

		System.out.println("<PepperoniPizza>");
		Pizza pepperoniPizza = pizzaStore.orderPizza("pepperoni");
	}
}
