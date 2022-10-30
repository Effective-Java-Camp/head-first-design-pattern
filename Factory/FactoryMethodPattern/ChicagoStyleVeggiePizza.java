package main.Factory.FactoryMethodPattern;

public class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "시카고 스타일 야채 피자";
		dough = "두꺼운 크러스트 도우";
		sauce = "플럼토마토 소스";
	}

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