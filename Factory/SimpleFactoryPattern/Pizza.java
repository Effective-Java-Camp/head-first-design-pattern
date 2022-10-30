package main.Factory.SimpleFactoryPattern;

public abstract class Pizza {
	void prepare() {
		System.out.println("Prepare");
	}

	void bake() {
		System.out.println("Bake");
	}

	void cut() {
		System.out.println("Cut");
	}

	void box() {
		System.out.println("Box");
	}
}

