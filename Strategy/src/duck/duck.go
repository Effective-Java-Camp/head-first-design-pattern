package duck

import "fmt"

// 나는 행동을 정의할 수 있는 인터페이스
type FlyBehavior interface {
	fly()
}

// 꽥꽥 행동을 정의할 수 있는 인터페이스
type QuackBehavior interface {
	quack()
}

// 오리 구조체
type Duck struct {
	Name          string
	FlyBehavior   FlyBehavior
	QuackBehavior QuackBehavior
}

func (d *Duck) GetName() {
	fmt.Printf("저는 %s입니다.\n", d.Name)
}

func (d *Duck) PerformFly() {
	d.FlyBehavior.fly()
}

func (d *Duck) PerformQuack() {
	d.QuackBehavior.quack()
}

// FlyBehavior 인터페이스의 구조체들
type FlyWithWings struct{}

type FlyNoWay struct{}

// 실제 구체적인 나는 행동을 구현
func (f FlyWithWings) fly() {
	fmt.Println("날고 있어요!!")
}

func (f FlyNoWay) fly() {
	fmt.Println("저는 못 날아요")
}

// QuackBehavior 인터페이스 구조체들
type Quack struct{}

type MuteQuack struct{}

type Squeak struct{}

// 실제 구체적인 꽥! 행동을 구현
func (q Quack) quack() {
	fmt.Println("꽥")
}

func (q MuteQuack) quack() {
	fmt.Println("<< 조용~ >>")
}

func (q Squeak) quack() {
	fmt.Println("삑")
}
