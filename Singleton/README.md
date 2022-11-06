## 싱글턴 패턴이란?

![image](https://user-images.githubusercontent.com/44438366/200169718-48d0a298-1179-43fb-bf65-1ef4dd67c0dc.png)

- 특정 클래스에 **객체 인스턴스가 하나**만 만들어지도록 해 주는 패턴
- 그 인스턴스로의 전역 접근을 제공함.
    - 다른 어떤 클래스에서도 자신의 인스턴스를 추가로 만들지 못하게 함.
    - 인스턴스가 필요하다면 반드시 클래스 자신을 거치도록 함.
- **게으른 인스턴스 생성**(lazy instantiation) =필요할 때만 객체를 만들 수가 있다.
    - 애플리케이션 시작될 때 객체가 생성되는 전역 변수 단점 보완.

## 알아가야할 점!

- 정적 클래스 변수와 메소드
- 접근 변경자
    - public 생성자가 없음. private!

이 두 개를 알면 어렵지 않음.

어떻게 하면 한 클래스의 인스턴스를 2개 이상 만들지 않게 하지? 는 사실상 간단한 질문은 아님.

## 활용도

- 연결 풀, 스레드 풀과 같은 자원 풀 관리

## 코드

```java
public class Singleton {
    private static Singleton uniqueInstance;

    // 기타 인스턴스 변수

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
    
    // 기타 메소드
}
```

그런데, 여기에는 멀티스레딩 문제가 있다.

### getInstance()를 동기화

getInstance()를 동기화하면 멀티스레딩과 관련된 문제가 간단하게 해결됨

```java
public class Singleton {
    private static Singleton uniqueInstance;

    // 기타 인스턴스 변수

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // 기타 메소드
}
```

Q. 문제가 해결되긴 하지만 동기화할 때 속도 문제가 생기지 않나요?

A. 맞음! 그리고 사실 동기화가 꼭 필요한 시점은 이 메소드가 시작되는 때뿐이다.

- uniqueInstance 변수에 Singleton 인스턴스를 대입하면 굳이 동기화된 상태로 유지할 필요가 없다. 처음을 제외하면 동기화는 오버헤드만 증가시킬 뿐이다.

### 더 효율적으로 멀티스레딩 문제 해결하기

1. getInstance()의 속도가 그리 중요하지 않다면 그냥 둔다.
    1. 다만 메소드를 동기화하면 성능이 100배 정도 저하된다는 사실만 기억해두자.
    2. 만약 getInstance()가 애플리케이션에서 병목으로 작용한다면 다른 방법을 생각해야 한다.
2. 인스턴스가 필요할 때는 생성하지 말고 처음부터 만든다.
    1. 인스턴스를 생성하고 계속 사용하거나 인스턴스 실행 중에 수시로 만들고 관리하기가 성가시다면 처음부터 Singleton 인스턴스를 만들면 좋다.
    2. 이 방법을 쓰면, 클래스가 로딩될 때 JVM에서 Singleton의 하나뿐인 인스턴스를 생성해준다. JVM에서 인스턴스를 생성하기 전까지 그 어떤 스레드도 uniqueInstance 정적 변수에 접근할 수 없다.

    ```java
    public class Singleton {
        private static Singleton uniqueInstance = new Singleton();
    
        private Singleton() {
        }
    
        public static Singleton getInstance() {
            return uniqueInstance;
        }
    }
    ```

3. DCL을 써서 getInstance()에서 동기화되는 부분을 줄인다.
    1. **DCL(Double-Checked Locking)**을 사용하면 인스턴스가 생성되어 있는지 확인한 다음 생성되어 있찌 않았을 때만 동기화할 수 있다. 이러면 처음에만 동기화하고 나중에는 동기화하지 않아도 된다.
    2. 자바 1.4 이전 버전에서는 쓸 수 없다.

    ```java
    public class DclSingleton {
        private volatile static DclSingleton uniqueInstance;
    
        private DclSingleton() {}
    
        public static DclSingleton getInstance() {
            if (uniqueInstance == null) {
                synchronized (DclSingleton.class) {
                    uniqueInstance = new DclSingleton();
                }
            }
            return uniqueInstance;
        }
    }
    ```


싱글턴을 구현하면 getInstance() 메소드를 사용할 때 발생하는 속도를 극적으로 줄일 수 있다.

### 동기화, 클래스 로딩, 리플렉션, 직렬화와 역직렬화 문제는

Enum 으로 싱글턴을 생성해서 해결할 수 있다!

```java
package doit_doit;

public enum EnumSingleton {
    UNIQUE_INSTANCE;
    // 기타 필요한 필드
}

public class SingletonClient {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.UNIQUE_INSTANCE;
        // 여기서 사용
    }
}
```

Enum을 사용한 싱글톤의 장점

1. 간단하다.
2. Enum 싱글톤은 Serialization을 스스로 해결한다.
3. reflection을 통한 공격에도 안전하다.