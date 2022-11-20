package main.State.Gumball;

public class WinnerState implements State {
	GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("Gumball이 나오고 있습니다.");
	}

	public void ejectQuarter() {
		System.out.println("Gumball이 나오고 있습니다.");
	}

	public void turnCrank() {
		System.out.println("Gumball이 나오고 있습니다.");
	}

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			System.out.println("당첨되어서 Gumball을 총 2개 획득했습니다!");
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("더 이상 Gumball이 없습니다.");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}
