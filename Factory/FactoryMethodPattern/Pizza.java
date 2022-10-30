package main.Factory.FactoryMethodPattern;

public abstract class Pizza {
	public String name;
	public String dough;
	public String sauce;

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

	public String getName() {
		return this.name;
	}
}