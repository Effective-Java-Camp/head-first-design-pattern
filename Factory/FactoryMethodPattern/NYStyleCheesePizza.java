package main.Factory.FactoryMethodPattern;

public class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza() {
		name = "뉴욕 스타일 소스와 치즈 피자";
		dough = "씬 크러스트 도우";
		sauce = "마리나라 소스";
	}

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
