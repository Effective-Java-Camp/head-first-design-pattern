package main

import "fmt"

type SecurityCode struct {
	code int
}

func newSecurityCode(code int) *SecurityCode {
	return &SecurityCode{
		code: code,
	}
}

func (s *SecurityCode) checkCode(incomingCode int) error {
	if s.code != incomingCode {
		return fmt.Errorf("암호 코드가 일치하지 않습니다.")
	}
	fmt.Println("암호코드 일치!")
	return nil
}
