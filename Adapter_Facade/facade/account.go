package main

import "fmt"

type Account struct {
	name string
}

func newAccount(accountName string) *Account {
	return &Account{
		name: accountName,
	}
}

func (a *Account) checkAccount(accountName string) error {
	if a.name != accountName {
		return fmt.Errorf("계좌명이 일치하지 않습니다.")
	}
	fmt.Println("계좌명 일치!")
	return nil
}
