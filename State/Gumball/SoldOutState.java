package main.State.Gumball;

public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("매진되었습니다.");
	}

	public void ejectQuarter() {
		System.out.println("동전을 넣지 않았습니다.");
	}

	public void turnCrank() {
		System.out.println("매진되었습니다.");
	}

	public void dispense() {
		System.out.println("Gumball을 내보낼 수 없습니다");
	}
}
