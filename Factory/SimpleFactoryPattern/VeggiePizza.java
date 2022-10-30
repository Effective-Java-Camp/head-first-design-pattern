package main.Factory.SimpleFactoryPattern;

public class VeggiePizza extends Pizza{
	@Override
	void prepare() {
		super.prepare();
		System.out.println("Add veggie");
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
