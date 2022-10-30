package main.Factory.FactoryMethodPattern;

public class Main {
	public static void main(String[] args) {
		PizzaStore nYStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		System.out.println("<NYStyleCheesePizza>");
		Pizza cheesePizza = nYStore.orderPizza("cheese");
		System.out.println(cheesePizza.getName());

		System.out.println("<ChicagoStyleVeggiePizza>");
		Pizza veggiePizza = chicagoStore.orderPizza("veggie");
		System.out.println(veggiePizza.getName());
	}
}
