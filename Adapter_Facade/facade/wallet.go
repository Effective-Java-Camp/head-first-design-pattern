package main

import "fmt"

type Wallet struct {
	balance int
}

func newWallet() *Wallet {
	return &Wallet{
		balance: 0,
	}
}

func (w *Wallet) creditBalance(amount int) {
	w.balance += amount
	fmt.Println("입금이 완료됐습니다.")
	return
}

func (w *Wallet) debitBalance(amount int) error {
	if w.balance < amount {
		return fmt.Errorf("출금이 실패했습니다!")
	}
	fmt.Println("출금이 성공적으로 완료됐습니다.")
	w.balance = w.balance - amount
	return nil
}
