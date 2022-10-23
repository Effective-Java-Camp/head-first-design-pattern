# Observer Pattern

감지하고 상태의 변경을 지켜보는 패턴. 여러개 객체들이 특정 하나의 상태 변화를 감지하고  
반응을 해야 할때 적용할수 있는 패턴. 이 패턴을 적용하면 pub/sub 패턴을 쉽게 구현할수 있다.

![스크린샷 2022-10-23 오후 3 07 06](https://user-images.githubusercontent.com/37957608/197376837-74b1312d-bd3d-43f4-8eb1-fbe3364f66c3.png)

sub 주요 기능: 여러 옵저버들을 등록하거나 해지할수있는 기능을 제공.  
client application은 이러한 sub의 주요한 기능을 이용하여 여러 옵저버들을 특정 sub에 등록하고,  
이 sub가 제공하는 특정한 메소드를 사용하여 sub 상태를 변경.  
sub가 변경되면 자신에게 등록되어 있는 obj를 순회하면서 옵저버가 제공하는 특정한 메소드를 호출.  
옵저버의 역할은 공통 인터페이스 제공, 이벤트가 발생했을때 옵저버의 호출해줘야 하는 메소드가 필요.  
그 이벤트가 담고 있는 정보 또는 그 이벤트 자체를 전달하여 특정 메소드를 실행.  

## 장점
- 상태를 변경하는 객체(pub)와 변경을 감지하는 객체(sub)의 관계를 느슨하게 유지할 수 있다.
- sub 상태 변경을 주기적으로 조회하지 않고 자동으로 감지할 수 있다.
- 런타임에 옵저버를 추가하거나 제거할 수 있다.

## 단점
- 복잡도가 증가한다.
- 다수의 Observer 객체를 등록 이후 해지하지 않는다면 memory leak이 발생할 수도 있다.

## Java 공부해볼만한 것들
- WeakReference : HasMap을 예를 들어, Map엔 들어있지만 참조 하지 않는 reference는 자동으로 삭제.  
다만 임시적인 방법. 단점은 언제 없어질지 알수 없고 명시적으로 해제하는것이 맞다.
- Java Observer Interface, Observerble class : 다만, Deprecated 됐다.
- Flow API : Java 9에 처음 도입된 API : Java에서 reactive stream을 구현할수 있도록 도와주는 인터페이스 목록
- SubmissionPublisher in Flow API : 비동기적으로 메시지를 처리할때 필요한 API  
이 reactive stream API 목적중 하나가 비동기 처리하면서 백프레셔를 관리. 흐름의 양을 조절
- Rx Java
- Reactor