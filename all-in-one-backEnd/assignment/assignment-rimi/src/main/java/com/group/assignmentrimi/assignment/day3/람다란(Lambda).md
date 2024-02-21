## 람다식 (Lambda Expression)

```
# JDK 1.8부터 추가된 람다식이란
메서드를 하나의 식(expression)으로 표현한 것이다.
메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 익명 함수 (anonymous function)이라고 한다.
람다의 도입을 통해 자바는 "객체지향언어"인 동시에 "함수형 언어"가 되었다.

또한 람다식은 메서드의 매개변수로 전달이 가능하고 메서드의 결과로 반환될 수도 있어,
람다식으로 인해 메서드를 변수처럼 사용 가능하다.

ex)
int[] arr = new int[5];
Arrays.setAll(arr, (i) -> (int)(Math.random() * 5) + 1);
```

---

## 함수형 인터페이스(Functional Interdace)

```
# 함수형 인터페이스
추상 메서드가 딱 1개만 있는 인터페이스이며 람다식을 통해 구현될 수 있습니다.
※단 default 메서드와 static 메서드는 존재할 수 있다.

대표적인 함수형 인터페이스로는 "java.util.function" 
패키지의 Predicate, Consumer, Function, Supplier 등이 있습니다.

또한 함수형 인터페이스의 가장 큰 이점 중 하나는 다양한 디자인 패턴을 쉽게 적용할 수 있습니다.
 
- java에서는 @FunctionalInterface 어노테이션을 사용하여 명시할 수 있습니다.
ex)
@FunctionalInterface
interface Comparator<T> {
    int compare(T o1, T o2);
}
```

---

## 람다식과 익명 클래스는 어떤 관계가 있을까?

```
# 람다식과 익명 클래스는 공통적으로 익명 함수를 구현하는 방법 중 하나입니다.

차이점으로는

1. 기능적 차이
람다식 : 
Java 8부터 도입되었으며, 함수형 프로그래밍 지원합니다.
주로 람다식은 단일 추상 메서드를 가진 인터페이스를 구현하기 위해 사용됩니다.

익명 클래스: 
클래스의 인스턴스를 생성하고 동시에 해당 클래스를 구현하는 객체를 정의할 수 있습니다.
이름이 없는 클래스로, 인터페이스 또는 클래스의 서브클래스를 구현하는 데 사용됩니다.

2. 구문적 차이
람다식:
간결하고 표현적인 문법을 제공합니다.
매개변수와 코드 블록으로 이루어져 있으며, 별도의 클래스나 메서드를 정의할 필요 없이 사용할 수 있습니다.

익명 클래스:
클래스의 정의를 통해 객체를 생성하고, 그 내부에 메서드를 구현합니다. 
클래스의 인스턴스를 생성하기 위해 new 키워드를 사용하며, 클래스 내부에 메서드를 오버라이드하여 동작을 정의합니다.

3. 성능적 차이
람다식:
람다식은 내부적으로 익명 클래스의 인스턴스를 생성하지만,
람다식은 보다 가벼운 방식으로 구현되어 일반적으로 더 효율적입니다.

익명 클래스:
런타임에 새로운 클래스 파일이 생성되므로 조금 더 많은 오버헤드가 발생할 수 있습니다
```

ㄴ 출처 :
[ChatGPT](https://chat.openai.com/)
[자바의정석](https://cafe.naver.com/javachobostudy)  
[Lambda-QuickStart](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)   
[java 8 doc](https://docs.oracle.com/javase/8/docs/api/index.html)  
[[10분 테코톡] 깃짱, 이리내의 람다와 스트림](https://www.youtube.com/watch?v=4ZtKiSvZNu4)
---

