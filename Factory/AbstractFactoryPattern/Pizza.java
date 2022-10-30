package main.Factory.AbstractFactoryPattern;

public abstract class Pizza {
	String name;

	Dough dough;
	Sauce sauce;

	abstract void prepare();

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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
