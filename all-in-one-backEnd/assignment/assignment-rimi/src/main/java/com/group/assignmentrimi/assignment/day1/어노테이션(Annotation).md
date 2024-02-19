## 어노테이션 (Annotation)

[질문]

1. 어노테이션을 사용하는 이유 (효과) 는 무엇일까?
2. 나만의 어노테이션은 어떻게 만들 수 있을까?

---

######

어노테이션이란  
코드에서 @으로 작성되는 요소를 어노테이션 (Annotation).  
어노테이션은 ***"클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리"*** 해야 할 것인지를 알려주는 설정 정보이다.  
`- 이것이 자바다 👍`

######

어노테이션이란  
자바 어노테이션(Annotation)은 소스 코드에 메타데이터를 추가하는 방법을 제공하는 기능입니다.  
어노테이션은 @ 기호로 시작하며, 컴파일러나 런타임 환경에게 정보를 전달할 수 있습니다.  
이러한 정보는 코드를 실행하거나 컴파일할 때 사용될 수 있습니다.  
어노테이션은 주석과 유사하게 생겼지만, 주석과는 달리 컴파일러가 읽고 처리할 수 있습니다.  
어노테이션은 프로그램에 추가적인 정보를 제공하거나 프로그램의 특정 부분에 대한 메타데이터를 정의하는 데 사용됩니다.  
예를 들어, 코드의 문서화, 컴파일러 경고 억제, 런타임 처리, 코드의 검증 등의 목적으로 사용될 수 있습니다.    
`- ChatGPT 👍`
---

어노테이션은 다양한 방법으로 사용이 되고 있는데,  
어노테이션의 가장 큰 장점으로는 ***코드를 간결*** 하게 만들 수 있다는 점입니다.

```
rimi.
실제 내가 개발을 진행할 때에도 어노테이션이 정말 코드를 간결하게 만들어준다.
예를 들어 하나의 VO를 만들 때에도 한 테이블에 컬럼이 많으면 100개정도가 되는데
만약 @Lombok이 없었다면 코드가 어마무시했을 것으로 생각된다...
ex) @Getter, @Setter, @Builder 등
```

아래에서는 어노테이션이 어떻게 이루어져있으면 왜 코드를 간결하게 만들 수 있는지 알아보겠습니다.

참고자료   
ㄴ [ORACLE : JSR 308 Explained: Java Type Annotations](https://www.oracle.com/technical-resources/articles/java/ma14-architect-annotations.html)  
ㄴ [The Java™ Tutorials : Lesson: Annotations](https://docs.oracle.com/javase/tutorial/java/annotations/index.html)  
ㄴ [The Java Language Specification, Java SE 21 Edition](https://docs.oracle.com/javase/specs/jls/se21/jls21.pdf)

##### java의 annotation

```
package java.lang.annotation;

If the annotation @Documented is present on the declaration of an annotation interface A, then any @A 
annotation on an element is considered part of the element's public contract. In more detail, when an 
annotation interface A is annotated with Documented, the presence and value of A annotations are a 
part of the public contract of the elements A annotates. Conversely, if an annotation interface B is not 
annotated with Documented, the presence and value of B annotations are not part of the public contract 
of the elements B annotates. Concretely, if an annotation interface is annotated with Documented, 
by default a tool like javadoc will display annotations of that interface in its output while annotations 
of annotation interfaces without Documented will not be displayed.
Since: 1.5
Author: Joshua Bloch

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {

}
```

##### java 어노테이션의 구성 요소

1. @Retention() - 어노테이션을 사용하여 컴파일 된 클래스의 생명 범위를 명시하기 위해 사용
2. @Target() - 어노테이션을 적용한 위치를 명시
3. @interface 이름 - 어노테이션의 이름

##### @Retention() 의 옵션

| 주요 속성                   | 설명                          |
|-------------------------|-----------------------------|
| RetentionPolicy.RUNTIME | 컴파일 이후에도 JVM에 의해서 참조가 가능하다. |
| RetentionPolicy.CLASS   | 컴파일러가 클래스를 참조할 때까지 유효하다.    |
| RetentionPolicy.SOURCE  | 어노테이션 정보는 컴파일 이후 없어진다.      |

##### @Target() 의 옵션

| 주요 속성                       | 설명          |
|-----------------------------|-------------|
| ElementType.PACKAGE         | 패키지 선언      |
| ElementType.TYPE            | 타입 선언       |
| ElementType.CONSTRUCTOR     | 생성자 선언      |
| ElementType.FIELD           | 멤버 변수 선언    |
| ElementType.METHOD          | 메소드 선언      |
| ElementType.ANNOTATION_TYPE | 어노테이션 타입 선언 |
| ElementType.LOCAL_VARIABLE  | 지역 변수 선언    |
| ElementType.PARAMETER       | 매개 변수 선언    |
| ElementType.TYPE_PARAMETER  | 매개 변수 타입 선언 |
| ElementType.TYPE_USE        | 타입 선언       |

---

##### 어노테이션의 주요 사용 용도

1. 컴파일 시 사용되는 정보 전달
2. 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
3. 실행(런타임) 시 특정 기능을 처리할 때 사용하는 정보 전달

---

##### 나만의 어노테이션 만들기

```
@Target(1.범위 지정)
@Retention(2.생명주기 설정)
public @interface 3. 어노테이션 이름 {
 4. 어노테이션 요소 정의
 ex) String value() default "";     // 기본값을 설정할 수 있는 요소 value 선언
     int count() default 0;         // 다른 요소도 선언 가능
}

1. 범위를 지정
2. 생명 주기 설정
3. 어노테이션 명칭 set
4. 어노테이션의 요소를 정의
```

---

``` 
한 걸음 더 ~!!
 
실무에서 사용하는 어노테이션에 대해 알아봅시다.

TODO : 오늘은 먼저 크게 2가지 종류에 대해 알아보고 추후 다른 md 파일로 정리 예정

@Lombok
1. @Getter: 해당 필드에 대한 getter 메서드를 생성합니다.
2. @Setter: 해당 필드에 대한 setter 메서드를 생성합니다.
3. @NoArgsConstructor: 파라미터 없는 기본 생성자를 생성합니다.
4. @AllArgsConstructor: 모든 필드를 포함하는 생성자를 생성합니다.
5. @Data: @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 모두 함께 사용하는 편리한 단일 어노테이션입니다.
6. @Builder: 빌더 패턴(builder pattern)을 사용하여 객체를 생성하는 빌더 메서드를 생성합니다.
7. @ToString: 객체의 toString() 메서드를 생성합니다.
8. @EqualsAndHashCode: 객체의 equals() 및 hashCode() 메서드를 생성합니다.
9. @Slf4j: 로깅을 위한 SLF4J(LoggerFactory) 인스턴스를 자동으로 생성합니다.

@Spring
1.  @SpringBootApplication: Spring Boot 애플리케이션의 주 진입점을 나타냅니다. 이 어노테이션은 @Configuration, @EnableAutoConfiguration, @ComponentScan 어노테이션을 결합한 것입니다.
2.  @Controller: Spring MVC에서 컨트롤러를 나타냅니다. HTTP 요청을 처리하고 응답을 생성하는 데 사용됩니다.
3.  @RestController: @Controller와 @ResponseBody를 합친 것으로, HTTP 요청에 JSON 또는 XML 형식으로 응답을 반환하는 RESTful 컨트롤러를 나타냅니다.
4.  @Service: 비즈니스 로직을 수행하는 서비스 클래스를 나타냅니다. 주로 서비스 계층에서 사용됩니다.
5.  @Repository: 데이터베이스 액세스를 위한 Spring의 DAO(Data Access Object)를 나타냅니다. 이 어노테이션은 데이터 액세스와 관련된 예외를 스프링이 효과적으로 처리할 수 있도록 지원합니다.
6.  @Autowired: 스프링에서 빈(bean)을 자동으로 주입할 때 사용되는 어노테이션입니다. 생성자, 필드, 메서드에 적용할 수 있습니다.
7.  @RequestMapping: 요청 경로와 HTTP 메서드에 대한 핸들러 메서드를 매핑하는 데 사용됩니다. 보통 컨트롤러 클래스나 메서드에 적용됩니다.
8.  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping: 각각 GET, POST, PUT, DELETE HTTP 메서드에 대한 핸들러 메서드를 매핑하는 데 사용됩니다. @RequestMapping의 단축 버전입니다.
9.  @PathVariable: 요청 경로에서 변수 값을 추출하는데 사용됩니다.
10. @RequestParam: HTTP 요청 매개변수의 값을 매핑하는데 사용됩니다.
11. @Value: 외부 설정 파일(application.properties 또는 application.yml)에서 값을 주입하는데 사용됩니다.
```

``` 
한 걸음 더 더 ~!
@Data 어노테이션은 사용을 지양하는데요 왜 지양할까요?
```