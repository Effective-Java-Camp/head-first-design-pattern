package main.Factory.SimpleFactoryPattern;

public class CheesePizza extends Pizza {
	@Override
	void prepare() {
		super.prepare();
		System.out.println("Add Cheese");
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
