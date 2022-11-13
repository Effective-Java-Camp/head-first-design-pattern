package main

import "fmt"

type Windows struct{}

func (w *Windows) insertIntoUSBPort() {
	fmt.Println("WINDOWS에 연결!!!")
}
