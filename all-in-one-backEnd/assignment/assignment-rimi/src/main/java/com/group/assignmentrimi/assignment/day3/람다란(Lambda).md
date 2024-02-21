1. 자바의 람다식은 왜 등장했을까?
2. 람다식과 익명 클래스는 어떤 관계가 있을까? - 람다식의 문법은 어떻게 될까?

## 람다식 (Lambda Expression)

```
람다식이란 메서드를 하나의 식(expression)으로 표현한 것이다.
메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 익명 함수 (anonymous function)이라고 한다.

또한 람다식은 메서드의 매개변수로 전달이 가능하고 메서드의 결과로 반환될 수도 있어,
람다식으로 인해 메서드를 변수처럼 사용 가능하다.

ex)
int method () {
 return (int)(Math.random() * 5) + 1;
}

```

---

## 함수형 인터페이스(Functional Interdace)

```
# 함수형 인터페이스
추상 메서드가 딱 1개만 있는 인터페이스 
※default 메서드와 static 메서드는 존재할 수 있다.

```

---

## 익명 클래스(Anonymous Class)

ㄴ 출처 :    
자바의정석  
[Lambda-QuickStart](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)   
[java 8 doc](https://docs.oracle.com/javase/8/docs/api/index.html)  
[[10분 테코톡] 깃짱, 이리내의 람다와 스트림](https://www.youtube.com/watch?v=4ZtKiSvZNu4)

---

