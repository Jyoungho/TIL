# Call by value, Call by reference

### Call by value

인자로 받은 값을 복사하여 처리한다. 복사하여 처리하기 때문에 메모리가 증가한다.

- 장점
    - 복사하여 처리하기 때문에 원래 값이 보존이 되서 안전한다.
- 단점
    - 메모리 양이 증가한다.
    
### Call by reference

인자로 받은 값을 주소로 참조하여 직접 값에 영향을 준다.

- 장점
    - 복사하지 않고 직접 참조하기 때문에 빠르다.
    - 원래 값에 영향을 받아 리스크가 있다.
    
### JAVA
- 함수를 호출하는 과정에서 주소 값을 복사해서 넘기는 구조라 call by reference 라고 착각 할 수 있지만, 실제 구조는 call by value 입니다.
- Java 는 기본적으로 모든 전달 방식이 Call by Value 형식이다.

### Python
- passed by assignmet
- 어떤 값을 전달하느냐에 따라 달라진다.
- 파이썬의 자료형엔 immutable(불변) 과 mutable(가변)이 존재한다.
- int, str → 불변, list, dictionary → mutable
- immutable object → call by value
- mutable object → call by reference

### javascript
- javascript 는 기본적으로 call by value 이다.
- 하지만 참조형 타입의 데이터인 경우 속성을 변경할 경우 원본 데이터도 같이 변하는 경우가 있다.
- java 와 같이 reference 값을 함수의 인자값으로 주어졌을때 주소를 복사하는 형식으로 call by value 가 진행되어 call by reference 로 착각하는 경우가 있다.