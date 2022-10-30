package main.Factory.SimpleFactoryPattern;

public class PepperoniPizza extends Pizza {
	@Override
	void prepare() {
		super.prepare();
		System.out.println("Add pepperoni");
	}

	@Override
	void bake() {
		super.bake();
	}

	@Override
	void cut() {
		super.cut();
	}

	@Override
	void box() {
		super.box();
	}
}
