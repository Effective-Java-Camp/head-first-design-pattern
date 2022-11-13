# Adapter & Facade 패턴

## Adapter 패턴
> **adapter 패턴**은 특정 클래스 인터페이스를 클라이언트에서 요구하는 다른 인터페이스로 변환한다.<br>
> 인터페이스가 호환되지 않아 같이 쓸 수 없었던 클래스를 사용할 수 있게 도와준다.

![image](https://user-images.githubusercontent.com/66015002/201476396-b4533149-3c9c-4361-9cfc-1a7f85589c63.png)

- Client에서는 Target 인터페이스를 볼 수 있다.
- Adapter에서 Target 인터페이스를 구현한다.
- Adapter는 Adaptee로 구성되어 있다.
- 모든 요청이 Adaptee로 위임된다.

### adapter 패턴 예시
![image](https://user-images.githubusercontent.com/66015002/201476437-d81ad22a-ccfa-420c-980f-0b23faf5aaed.png)

- 어댑터는 기존 시스템이 새로운 클래스를 수용할 수 있는 형태로 변환시켜주는 중개인 역할을 한다.

## Facade 패턴

> **facade 패턴**은 서브시스템에 있는 일련의 인터페이스를 통합 인터페이스로 묶어 준다<br>
> 고수준 인터페이스도 정의하므로 서브시스템을 더 편리하게 사용할 수 있다.

![image](https://user-images.githubusercontent.com/66015002/201503473-12c44326-2fb2-4de4-9e5c-305b9793edc0.png)


### 최소 지식 원칙
> 객체 사이의 상호작용은 될 수 있으면 아주 가까운 '친구' 사이에만 허용하는 편이 좋다<br>
> 즉 어떤 객체든 그 객체와 상호작용 하는 클래스의 개수와 상호작용 방식에 주의를 기울여라


#### 최소 지식 원칙을 따르지 않는 경우

```java
public float getTemp() {
  // station에서 thermometer라는 객체를 받아서
  // 그 객체의 getTemperature() 메서드를 직접 호출해야 한다.
  Thermometer thermometer = station.getThermometer();
    return thermometer.getTemperature();
}
```

#### 최소 지식 원칙을 따르는 경우
```java
public float getTemp() {
  // 디미터 법칙(최소 지식 원칙)을 적용해서 Station 클래스에
  // thermometer에 요청을 해주는 메서드를 추가했다.
  // 이렇게 하면, 의존해야 하는 클래스의 개수를 줄일 수 있다.
  return station.getTemperature();
}
```
