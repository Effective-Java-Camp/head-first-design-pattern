package main.State.Gumball;

public class NoQuarterState implements State {
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("동전이 들어왔습니다.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	public void ejectQuarter() {
		System.out.println("동전이 없습니다.");
	}

	public void turnCrank() {
		System.out.println("동전이 없습니다.");
	}

	public void dispense() {
		System.out.println("동전을 넣어야합니다.");
	}
}
