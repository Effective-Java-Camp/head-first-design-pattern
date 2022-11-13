package main

import "fmt"

type Client struct {
}

func (c *Client) InsertLightningConnectorIntoComputer(com Computer) {
	fmt.Println("client 연결중...")
	com.InsertIntoLightningPort()
}
