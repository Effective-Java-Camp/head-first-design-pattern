# 팩토리 패턴 (Factory Pattern)

들어가기 전에...
왜 쓰는가?
객체를 생성하는 코드만 분리하여 클라이언트 코드와의 결합도를 낮추어, 코드 변경을 최소화하기 위해 쓴다.
OCP(확장에 열려있고, 수정에 닫혀있어야한다)를 지키기 위해 변경 가능성이 큰 객체 생성을 담당하는 클래스를 분리한다.

## 1. Simple Factory
### 기존 코드의 문제
```java
Duck duck;
if (picnic) {
	duck = new MallardDuck();
}
else if (hunting) {
	duck = new DcoyDuck();
})
```
인터페이스를 사용해서 코드를 유연하게 만드려고 했으나, 특정 구현 클래스에 의존적
=> 변경이나 확장이 어려운 코드

### 변경되는 부분 찾기
```java
Pizza orderPizza(String type) {
    Pizza pizza;
    
	// 피자 종류가 바뀔 때마다 코드를 계속 수정해야한다.
    if (type.equals("cheese")) {
        pizza = new CheesePizza(); 
    } elseif(type.equals("greek")) {
        pizza = new GreekPizza(); 
    } else if (type.equals("pepperoni") { 
        pizza = new PepperoniPizza();
    }
    
    // 아래 코드는 바뀌지 않는다.
	pizza.prepare(); //피자 준비
    pizza.bake();  // 피자 굽기
    pizza.cut();  //피자 자르기
    pizza.box();  // 피자 상자에 담기
    return pizza;
 }
```
인스턴스를 만뜨는 구상 클래스를 선택하는 부분은 변경 될 수 있는 부분.
OCP 원칙을 지키기 위해 변경될 수 있는 부분을 나머지 부분으로부터 분리(캡슐화)

### 팩토리 만들기
Factory: 객체 생성을 처리하는 클래스
```java
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if(type.equals("clam")) {
            pizza = new ClamPizza();
        } else if(type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
    return pizza;
    }
}
```

- 피자 객체 생성 작업이 필요한 클라이언트가 많을 경우, 해당 클라이언트에서 수정할 필요 없이, 팩토리 클래스 하나만 고칠 수 있다.
- static factory method: 정적 메소드를 쓰면 팩토리 객체의 인스턴스를 만들지 않아도 된다. 하지만 서브클래스를 만들어 객체 생성 메소드의 행동을 변경할 수 없다는 단점도 있다.

PizzaStore
```java
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
```

## 2. 팩토리 메서드 패턴
다양한 팩토리를 만들고, PizzaStore와 피자 제작 코드를 묶어준다.
SimplePizzaFactory -> NYPizzaFactory, ChicagoPizzaFactory, CaliforniaPizzaFactory
```java
NYPizzaFactory nyFactory = new NYPizzaFactory(); 
PizzaStore nyStore = new PizzaStore(nyFactory);
nyStore.orderPizza("Veggie"); 

ChicagoPizzaFactory chicagoFactory = new ChicagoPizzaFactory(); 
PizzaStore chicagoStore = new PizzaStore(chicagoFactory); 
chicagoStore.orderPizza("Veggie"); 
```

### PizzaStore
SimpleFactory 방식에서는 Factory에 넣었던 createPizza를 다시 PizzaStore에 넣고, 추상 메소드로 선언하여 서브클래스에서 수정할 수 있도록 한다.
```java
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); //서브클래스에서 결정

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type); //팩토리 객체 대신 이 메소드를 사용!
}
```

### NYPizzaStore
```java
public class NYPizzaStore extends PizzaStore {
	
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else if(type.equals("clam")) {
            return new NYStyleClamPizza();
        } else if(type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }

	public class NYStyleCheesePizza extends Pizza {

		public NYStyleCheesePizza() {
			name = "뉴욕 스타일 소스와 치즈 피자";
			dough = "씬 크러스트 도우";
			sauce = "마리나라 소스";
		}
	}
}
```

### consumer 코드
```java
  NYPizzaFactory nyFactory = new NYPizzaFactory();
  PizzaStore nyStore = new PizzaStore(nyFactory);
  nyStore.orderPizza("cheese");
```
기존에는 피자가게와 피자를 생성하는 부분이 나뉘어져있었다면, 이제는 피자가게가 피자를 생성하는 부분을 포함.
```java
    PizzaStore pizzaStore = new NYPizzaStore();
    pizzaStore.orderPizza("cheese");
```

### 팩토리 메소드 패턴의 정의
클래스 인스턴스를 만드는 일을 서브클래스에게 맡긴다.
객체를 생성할 때 필요한 인터페이스를 만들고, 서브클래스에서 생산할 객체 인스턴스를 결정.

## 의존성 뒤집기 원칙
Dependency Inversion Principle:
추상화된 것에 의존하게 만들고,
구상 클래스에 의존하지 않게 만든다. 

고수준 구성 요소가 저수준 구성 요소에 의존하면 안되며 항상 추상화에 의존하게 만들어야한다.

PizzaStore: 고수준 구성 요소, Pizza: 저수준 구성 요소

```java
public Pizza createPizza(String style, type) {
	Pizza pizza = null;
	if (style.equals = "NY") {
		if (type.equals("cheese")) {
			pizza = new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
			pizza = new NYStyleVeggiePizza();
        }
		//....
    }
}
```
위와 같이 PizzaStore에서 구체적인 피자 클래스들을 의존하게 되면 구상 클래스가 변경될 때 PizzaStore까지 바뀌어야할 수 있다.

그래서 팩토리 메소드 패턴을 사용해서 pizza 인스턴스를 만드는 부분을 뽑아내어서 의존성 뒤집기 원칙을 준수하도록 할 수 있다.

가이드라인
1) 변수에 구상 클래스의 레퍼런스를 저장하지 말자
2) 구상 클래스에서 유도된 클래스를 만들지 말자 (인터페이스나 추상 클래스처럼 추상화된 것으로부터 클래스를 만들자)
3) 베이스 클래스에 이미 구현되어 있는 메소드를 오버라이드하지 말자
- 이미 구현되어 있는 메소드를 오버라이드하면 베이스 클래스가 제대로 추상화되지 않는다.
- 베이스 클래스에는 모든 서브클래스에서 공유할 수 있는 것만 정의하자.

## 3. 추상 팩토리 패턴
### 원재료 팩토리
피자 종류에 맞는 원재료를 생산하는 추상 팩토리 도입
```java
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
}
```

```java
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
```

```java
public class NYPizzaStore extends PizzaStore {
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
            new NYPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
		}
		//...
    }
}
```

추상 팩토리 패턴:
구상 클래스에 의존하지 않고도 서로 연관되거나 의존적인 객체로 이루어진 제품군을 생산하는 인터페이스 제공
구상 클래스는 서브클래스에서 만듦. 
클라이언트와 팩토리에서 생산되는 제품을 분리할 수 있음. 

팩토리 메소드 vs 추상 팩토리 패턴
- 팩토리 패턴은 한 종류의 객체를 생성하기 위해 사용. 추상 팩토리 패턴은 연관되거나 의존적인 객체로 이루어진 여러 종류의 객체를 생성하기 위해 사용
- 팩토리 패턴은 팩토리 인터페이스를 구현, 추상 팩토리는 팩토리 객체가 아닌 다른 객체 내부에 구현되어 해당 객체에서 여러 타입의 객체를 생성하기 위해 사용. 

## 다이어그램
### Simple Factory
<img width="798" alt="스크린샷 2022-10-30 오후 9 27 11" src="https://user-images.githubusercontent.com/47516074/198878401-40a7c873-729b-4555-a476-5d814db6414d.png">

### Factory Method Pattern
<img width="804" alt="스크린샷 2022-10-30 오후 9 29 26" src="https://user-images.githubusercontent.com/47516074/198878492-e335cb87-6f53-4d33-b47f-350c7eaa2102.png">
<img width="649" alt="스크린샷 2022-10-30 오후 9 29 52" src="https://user-images.githubusercontent.com/47516074/198878514-a423010a-7790-4c9c-b08a-7c83dd451cf6.png">

### Abstract Factory Pattern
<img width="642" alt="스크린샷 2022-10-30 오후 9 30 53" src="https://user-images.githubusercontent.com/47516074/198878555-2beeadce-b3b6-4763-be7c-2a4c3d1fe660.png">
