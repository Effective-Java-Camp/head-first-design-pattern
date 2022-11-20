# 상태 패턴 (State Pattern)

객체가 상태에 따라 행동이 달라져야하는 상황에서, 
직접 상태를 체크하여 상태에 따른 행동을 하지 않고 상태를 객체화하여 상태가 행동을 하도록 위임하는 패턴

## 상태 패턴을 쓰지 않을 경우
```java
public class GumballMachine {

	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;

	int state = SOLD_OUT;
	int count = 0;

	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			System.out.println("Please wait, we're already giving you a gumball");
		}
	}

	//...생략
}
```

- 수정/확장시 각 메소드의 조건문 코드를 매번 수정해야한다
- 상태 전환이 조건문 속에 숨어 있어서 수정이 어렵고, 바뀌는 부분이 캡슐화되지 않았다. => 상태별로 일어나는 일을 캡슐화해서 하나의 상태 코드 수정이 다른 코드에 영향을 미치지 않도록 수정해야한다.

## 상태 패턴
- 상태별 행동을 별개의 클래스로 구현하고, 각 상태에서 자신의 행동을 구현
- 각 상태는 변경에는 닫혀 있고, GumballMachine 클래스는 새로운 상태 클래스를 추가하는 확장에 열려있다(OCP)
- 객체 내부 상태가 바뀜에 따라 객체의 행동을 바꿀 수 있다 -> 객체의 클래스가 바뀌는 것 같은 결과

<img width="649" alt="스크린샷 2022-11-20 오후 6 48 17" src="https://user-images.githubusercontent.com/47516074/202895534-09ade757-73f3-476c-88a1-51ff4113328d.png">

<img width="637" alt="스크린샷 2022-11-20 오후 6 48 29" src="https://user-images.githubusercontent.com/47516074/202895541-3cd0b1b9-89ea-4e55-95e7-7508c5e09109.png">

+) 구상 상태 클래스에서 다음 상태를 결정해야하는가?
=> Context에서 결정해도 된다. 
- 상태 전환이 고정되어 있으면 Context에 넣어도 되지만, 동적으로 결정된다면 상태 클래스 내에서 처리하는 것이 좋다.
- 예를 들어 GumballMachine에서 NoQuarter, SoldOut으로 전환하는 결정은 실행 중 남아있는 알맹이 개수에 따라 동적으로 결정

## 상태 패턴 vs 전략 패턴
둘 다 구현 객체를 지정해줘서 행동을 유연하게 변경해줄 수 있지만, 용도가 다르다.
전략 패턴에서는 클라이언트가 Context 객체에게 어떤 전략 객체를 사용할지 지정해준다. 
상태 패턴에서는 클라이언트는 상태 객체를 몰라도 된다. 내부 상태가 바뀜에 따라 객체가 알아서 행동을 바꾼다. 

## 장점
- 단일 책임 원칙: 특정 상태 관련 코드는 한 클래스에 들어간다
- OCP: 기존 state 클래스들이나 context를 변경하지 않으면서 새로운 state를 도입할 수 있다.
- 조건문을 없애서 context의 코드를 단순화할 수 있다.

## 단점
- state가 별로 없거나, 거의 변하지 않을 경우 해당 패턴 사용이 overkill이 될 수 있다.
