package main.Factory.FactoryMethodPattern;

public class NYStylePepperoniPizza extends Pizza {
	public NYStylePepperoniPizza() {
		name = "뉴욕 스타일 소스와 페페로니 피자";
		dough = "씬 크러스트 도우";
		sauce = "마리나라 소스";
	}

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

