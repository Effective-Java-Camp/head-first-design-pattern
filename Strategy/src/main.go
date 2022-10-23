package main

import (
	"beutiful-design-pattern/chapter1/src/duck"
	"fmt"
)

func main() {
	parkDuck := duck.Duck{
		Name:          "병찬오리",
		FlyBehavior:   duck.FlyNoWay{},
		QuackBehavior: duck.Squeak{},
	}
	parkDuck.GetName()
	parkDuck.PerformFly()
	parkDuck.PerformQuack()

	fmt.Println("-----------------------------")

	fakeParkDuck := duck.Duck{
		Name:          "짭병찬오리",
		FlyBehavior:   duck.FlyWithWings{},
		QuackBehavior: duck.Quack{},
	}
	fakeParkDuck.GetName()
	fakeParkDuck.PerformFly()
	fakeParkDuck.PerformQuack()

}
