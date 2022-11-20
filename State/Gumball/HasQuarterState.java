package main.State.Gumball;

import java.util.Random;

public class HasQuarterState implements State {
	GumballMachine gumballMachine;
	Random randomWinner = new Random(System.currentTimeMillis());

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("동전을 이미 넣었습니다.");
	}

	public void ejectQuarter() {
		System.out.println("동전을 반환합니다.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank() {
		System.out.println("돌리는중~");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	public void dispense() {
		System.out.println("gumball을 내보낼 수 없습니다.");
	}
}
