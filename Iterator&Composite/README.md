# Iterator Pattern

![image](https://user-images.githubusercontent.com/75432228/202729930-0ff082d2-251c-4e46-b1c4-f2fbda391aa4.png)


- 정의 : 컬렉션의 구현 방법을 노출하지 않으면서 집합체 내의 모든 항목에 접근하는 방법을 제공하는 패턴
- iterator 인터페이스를 구현해서 반복이 가능하게 만든다
    - next(), remove() 등등을 구현 해준다
    
| 장점 | 단점|
|:--:|:--:|
|다양한 데이터 순회 알고리즘을 코드를 분리할 수 있다.(단일책임원칙,SRP) <br>기존 코드를 수정하지 않고도 새로운 타입의 콜랙션과 이터레이터를 추가할 수 있다.(개방/폐쇄원칙,OCP)<br>객체마다 이터레이터를 가지고 있기 때문에 같은 콜랙션을 병렬처리할 수 있다.<br>필요할 때, 순회(iteration)을 지연시키거나, 이어서 진행할 수 있다.| 간단한 컬렉션의 경우 패턴을 적용하는 것은 지나칠 수 있다.<br>반복자를 사용하는 것은 일부 특수 컬렉션의 요소를 직접 탐색하는 것 보다 덜 효율적일 수 있다.|

```java
public interface Iterable<T> {

    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}

```


```java
public interface Iterator<E> {

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}

```

> Iterator vs Visitor <br>
Visitor 는 노드에서 노드로 자신이 넘겨지는 반면, Iterator 는 하나의 노드 내부를 탐색하기 위함이다

> 외부반복자 vs 내부반복자

외부반복자: 흔히 배열애서 요소를 for나 while 등의 루프로 하나씩 꺼내서 직접 조작하는 방식
```java
List<Integer> list  = Arrays.asList(1,2,3);
Iterator<Integer> iterator = list.iterator();

while(iterator.hasNext()){
     String name = iterator.next();
     System.out.println(num);
}
```
내부반복자: 사용자는 반복당 수행할 액션만을 제공하고, 그 액션을 컬렉션이 받아 내부적으로 처리하는 방식 (수행 액션은 보통 콜백 함수로 전달)
```java
List<Integer> list  = Arrays.asList(1,2,3);
Stream<Integer> stream = list.stream();

stream.forEach(num -> System.out.println(num)); // 매개 값에 람다식을 사용
```

# Composite Pattern

![image](https://user-images.githubusercontent.com/75432228/202888108-ffef1681-0de0-4401-a1ce-1a96c1c1ddf2.png)


컴포지트(복합객체) 패턴
- 정의 : 객체들을 트리 구조로 구성하여 부분-전체 게층 구조 구현
        이 패턴을 이용하면 클라이언트에서 개별 객체와 복합 객체(composite)를 똑같은 방법으로 다룰 수 있다
- 복합 객체
    - 부분-전체 계층 구조 (part-whole hierarchy)
        - 부분들이 모여 있지만 모든 것을 하나로 묶어서 전체로 다룰 수 있는 구조
    - 트리 구조에 있어서 맨 위던, 중간 이던, 마지막에 있던 (자식 노드가 있던 없던) 똑같은 객체로 다룰 수 있다
- Component 인터페이스를 정의하고, Leaf 와 Composite 가 이를 구현
- 단일 역할 원칙을 지키고 있지 않다
    - 컴포지트 패턴은 단일 역할 원칙을 깨는 대신에 투명성을 확보하기 위한 패턴
    - 투명성(transparancy)란
        - Component 인터페이스에 자식들을 관리하기 위한 기능과 잎으로써의 기능을 전부 집어넣음으로써
          클라이언트에서 복합 객체와 잎 노드를 똑같은 방식으로 처리할 수 있도록 하는 것
        - 어떤 원소가 복합 객체인지 잎 노드인지가 클라이언트 입장에서는 투명하게 느껴진다
- 안전성이 떨어진다
    - Component 클래스에는 두 종류의 기능이 모두 들어있다 보니 안전성은 떨어진다
    - 클라이언트에서 어떤 원소에 대해 무의미한, 또는 부적절한 작업을 처리하려고 할 수도 있다 (메뉴 항목에 메뉴를 추가 등)
    - 하지만 위 문제를 해결하기 위해서 다른 방향으로 디자인해서 여러 역학을 서로 다른 인터페이스로 분리시키면 매번 instance of연산자를 매번 호출해야 할 수도 있다
 
    
| 장점 | 단점|
|:--:|:--:|
|객체들이 모두 같은 타입으로 취급되기 때문에 새로운 클래스 추가가 용이하다.<br>단일객체, 집합객체 구분하지 않고 코드 작성이 가능하다.| 설계를 일반화 시켜 객체간의 구분, 제약이 힘들다.|

