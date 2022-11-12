package main

import "fmt"

type Notification struct {
}

func (n *Notification) sendWalletCreditNotification() {
	fmt.Println("입금 후 잔액은???")
}

func (n *Notification) sendWalletDebitNotification() {
	fmt.Println("출금 후 내 잔액은???")
}
