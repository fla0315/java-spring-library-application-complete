## 네 번째 과제! (진도표 4일차)

---
우리는 GET API와 POST API를 만드는 방법을 배웠습니다. 👍  
추가적인 API 들을 만들어 보며 API 개발에 익숙해져 봅시다!

``` 4일차 문제1, 문제2, 문제3은 이어지는 문제입니다. ```

---
**[문제1]**  
우리는 작은 과일 가게를 운영하고 있습니다.  
과일 가게 입고된 "과일 정보"를 저장하는 API를 만들어 봅시다.  
스펙은 다음과 같습니다.

- HTTP method : ```POST```
- HTTP path : ```/api/v1/fruit```
- HTTP 요청 body

```
{
    "name": String,
    "warehousingDate": LocalDate,
    "price": Long
}
```

**HTTP 요청 Body 예시**

```
{
    "name": "사과",
    "warehousingDate": "2024-02-01",
    "price": 5000
}
```

**응답: 성공시 200**

```
# 한걸음 더
자바에서 정수를 다루는 가장 대표적인 두 가지 방법은 "int" 와 "long"입니다.
이 두 가지 방법 중 위 API에서 "long"을 사용한 이유는 무엇일까요?
```

---
**[문제2]**  
과일이 팔리게 되면, 우리 시스템에 팔린 과일 정보를 기록해야 합니다.  
스펙은 다음과 같습니다

**예시**

- HTTP method : ```PUT```
- HTTP path : ```/api/v1/fruit```
- HTTP 요청 body

```
{
    "id": long
}
```

**HTTP 요청 Body 예시**

```
{
    "id": 3
}
```

**응답: 성공시 200**
우리는 특정 과일을 기준으로 팔린 금액,  
팔리지 않은 금액을 조회하고 싶습니다.  
예를 들어

1. (1, 사과, 3000원, 판매 O)
2. (2, 사과, 4000원, 판매 X)
3. (3, 사과, 3000원, 판매 O)

와 같은 세 데이터가 있다면 우리의 API는  
판매된 금액: 6000원,  
판매되지 않은 금액: 4000원 이라고 응답해야 합니다.  
구체적인 스펙은 다음과 같습니다.

**예시**

- HTTP method : ```GET```
- HTTP path : ```/api/v1/fruit/stat```
- HTTP query
    - name : 과일이름
- 예시 ```GET/api/v1/fruit/stat?name=사과```

```
{
    "salesAmount": long,
    "nonSalesAmount": long,
}
```

**HTTP 응답 Body 예시**

```
{
    "salesAmount": 6000,
    "nonSalesAmount": 4000,
}
```

**응답: 성공시 200**

```
# 한걸음 더
(문제 3번을 모두 푸셨다면) SQL의 sum, group by 키워드를 검색해 적용해보세요.
```

---