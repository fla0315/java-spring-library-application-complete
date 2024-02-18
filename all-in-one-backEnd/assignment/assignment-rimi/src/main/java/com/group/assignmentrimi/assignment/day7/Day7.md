## 일곱 번째 과제! (진도표 7일차)

#####

우리는 JPA라는 개념을 배우고 유저 테이블에 JPA를 적용해 보았습니다.  
몇 가지 문제를 통해 JPA를 연습해 봅시다! 🔥

---
**[문제1]**  
과제 #6에서 만들었던 Fruit 기능들을 JPA를 이용하도록 변경해 보세요.
---

**[문제2]**  
우리는 특정 과일을 기준으로 지금까지 우리 가게를 거쳐갔던 과일 갯수를 세고 싶습니다.
<문제1>에서 만들었던 과일 Entity Class를 이용해 기능을 만들어 보세요.

예를 들어

1. (1, 사과, 3000원, 판매 O)
2. (2, 바나나, 4000원, 판매 X)
3. (3, 사과, 3000원, 판매 O)
   와 같은 세 데이터가 있고, 사과를 기준으로 과일 갯수를 센다면, 우리의 API는 2를 반환할 것입니다.

스펙은 다음과 같습니다.

- HTTP method : ```GET```
- HTTP path : ```/api/v1/fruit/count```
- HTTP query
    - name : 과일 이름
- 예시: ```GET/api/v1/fruit/count?name=사과 ```

**HTTP 응답 Body**

```
{
    "count": long
}
```

**HTTP 응답 Body 예시**

```
{
    "count": 2
}
```

---

**[문제3]**  
우리는 아직 판매되지 않은 특정 금액 이상 혹은 특정 금액 이하의 과일 목록을 받아보고 싶습니다.
구체적인 스펙은 다음과 같습니다.

- HTTP method : ```GET```
- HTTP path : ```/api/v1/fruit/list```
- HTTP query
    - option : "GTE" 혹운 "LTE" 라는 문자열이 들어온다.
        - GTE : greater than equal 의 의미
        - LTE : less than equal 의 의미
    - price : 기준이 되는 금액이 들어온다.
- 예시1 : ```GET/api/v1/fruit/list?option=GTE&price=3000 ```
    - 판매되지 않는 3000원 이상의 과일 목록을 반환한다.
- 예시1 : ```GET/api/v1/fruit/list?option=LTE&price=5000 ```
    - 판매되지 않은 5000원 이하의 과일 목록을 반환한다.

**HTTP 응답 Body**

```
[
    {
        "name": String,
        "price": long,
        "warehousingDate": LocalDate,
    }, ...
]
```

**HTTP 응답 Body 예시**

```
[
    {
        "name": "사과",
        "price": 4000,
        "warehousingDate": "2024-01-05",
    },
    {
        "name": "바나나",
        "price": 6000,
        "warehousingDate": "2024-01-08",
    }
]
```

---