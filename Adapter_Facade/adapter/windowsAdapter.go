package main

import "fmt"

type WindowsAdapter struct {
	windowMachine *Windows
}

func (w *WindowsAdapter) InsertIntoLightningPort() {
	fmt.Println("adapter convert!!!")
	w.windowMachine.insertIntoUSBPort()
}
