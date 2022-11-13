package main

import "fmt"

type Ledger struct {
}

func (s *Ledger) makeEntry(accountID, txnType string, amount int) {
	fmt.Printf("이름: %s 타입: %s 금액: %d\n", accountID, txnType, amount)
	return
}
