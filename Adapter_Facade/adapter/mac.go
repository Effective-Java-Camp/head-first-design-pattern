package main

import "fmt"

type Mac struct {
}

func (m *Mac) InsertIntoLightningPort() {
	fmt.Println("MAC에 연결!!")
}
