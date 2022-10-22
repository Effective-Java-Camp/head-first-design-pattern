# Ch.1 디자인 패턴과 전략 패턴

## 오리 시뮬레이션 설계

1. Duck 슈퍼클래스 생성, 오리들은 이 클래스를 상속

     
```kotlin
abstract class Duck {
   quack() { "꽥꽥" }   // 모든 오리는 꽥꽥거리고 물에 뜨므로 미리 구현
   swim() { "수영" }
   display() // 모양은 서로 다르기 때문에 추상메소드
 }
```
```kotlin
class MallardDuck : Duck {
	override fun display() // 무슨무슨 오리
}

class RedHeadDuck : Duck {
	override fun display() // 어떤어떤 오리
}
```

-> 오리가 날 수 있도록 해주세요!
 

```kotlin
abstract class Duck {
   quack() { "꽥꽥" }
   swim() { "수영" }
   display()
   fly()   // 이걸 추가하면 되지않을까?
 }
```
> 문제점1 : <br> 일부 서브클래스는 필요하지 않은 기능도 상속받게 됨
     (슈퍼클래스의 코드 변경 시 원치 않은 영향을 끼칠 수 있음)
     
-> 고무오리가 날게 되는 불상사가 발생한다.

     

```kotlin
class RubberDuck : Duck {
	override fun quack() { "삑삑" } // 삑삑으로 오버라이드 
	override fun fly() {  } // 아무것도 하지 않도록 오버라이드
	override fun display() 
 }
 ```
 > 문제점2: 필요하지 않은 기능을 작동하지 않도록 오버라이드
     (서브클래스에서 코드가 중복됨, 어떤 클래스에서 어떤 오버라이드 중인지 매번 확인해야함)


<br>

2. 해당 기능들을 Behavior 인터페이스로 분리

```kotlin
abstract class Duck {
	swim()
	display()
 }
 
 interface Flyable {
	fly()
 }
 
interface Quackable {
	quack()
 }
```


```kotlin
class MallardDuck : Duck, Flayable, Quackable {
	override fun display()
	override fun fly()
	override fun quack()
 }
 
class RubberDuck : Duck, Quackable {
	override fun display()
	override fun quack()
 }
 
 class WoodDuck : Duck {
 	override fun display()
 }
```
 > 문제점: <인터페이스는 모든 서브클래스에서 구현해야하므로 관리가 힘듦 <br>
 또한 날 수 있는 오리에게는 나는 코드를 복붙해야한다. 즉 코드 재활용이 안된다.
 

## 디자인 원칙

- 애플리케이션의 달라지는 부분을 찾아내고, 달라지지 않는 부분과 분리한다.
  - 달라지는 부분을 추출해 캡슐화한다.
- 구현보다는 인터페이스에 맞춰서 프로그래밍한다.
- 상속보다는 구성을 활용한다.

| | 상속(Inheritance) | 구성(Composition) |
|:--:|:--:|:--:|
| 관계 | is-a | has-a |
| 기능 | 클래스가 클래스를 확장하여 속성 및 동작을 상속 |클래스가 다른 클래스의 객체를 멤버 데이터로 포함|
| 캡슐화| X | O |

## 전략(Strategy) 패턴

알고리즘군을 정의하고 캡슐화해서 각각의 알고리즘군을 수정해서 쓸 수 있게 한다. <br>
전략 패턴을 사용하면 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경할 수 있다.

<b>= 행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴</b>

<br>

## 인터페이스와 상위 형식에 맞춰 프로그래밍

1. 인터페이스 선언
```go
type FlyBehavior interface {
	fly()
}
```

2. 구체적인 구현 메소드 정의
```go
type FlyWithWings struct{}

type FlyNoWay struct{}

// 실제 구체적인 나는 행동을 구현
func (f FlyWithWings) fly() {
	fmt.Println("날고 있어요!!")
}

func (f FlyNoWay) fly() {
	fmt.Println("저는 못 날아요")
}
```

3. 오리 구조체에 할당
```go
type Duck struct {
	Name          string
	FlyBehavior   FlyBehavior
}

func (d *Duck) GetName() {
	fmt.Printf("저는 %s입니다.\n", d.Name)
}

func (d *Duck) PerformFly() {
	d.FlyBehavior.fly()
}
```

4. 실행
```go
parkDuck := duck.Duck{
		Name:          "병찬오리",
		FlyBehavior:   duck.FlyNoWay{},
	}
	parkDuck.GetName()
	parkDuck.PerformFly()
```
