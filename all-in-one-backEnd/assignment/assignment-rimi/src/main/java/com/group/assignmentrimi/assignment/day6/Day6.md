## 여섯 번째 과제! (진도표 6일차)

#####
우리는 스프링 컨테이너의 개념을 배우고,  
기존에 작성했던 Controller 코드를 3단 분리해보았습니다.  
앞으로 API를 개발할 때는 이 계층에 맞게 각 코드가 작성되어야 합니다! 🙂

과제 #4 에서 만들었던 API를 분리해보며,  
Controller - Service - Repository 계층에 익숙해져 봅시다! 👍
---
**[문제1]**  
과제 #4에서 만들었던 API를 강의 내용 처럼 Controller - Service - Repository로 분리해보세요
---
**[문제2]**  
문제 1에서 코드가 분리되면
``` FruitController ``` / ``` FruitService ``` / ``` FruitRepository ``` 가 생겼을 겁니다.    
기존에 작성했던 ``` FruitRepository ``` 를 ``` FruitMemoryRepository ```와 ``` FruitMySqlRepository ```로 나누고  
``` @Primary ``` 어노테이션을 활용해 두 Repository를 바꿔가며 동작시킬 수 있도록 코드를 변경해보세요.

```
# @Qualifier 어노테이션을 사용해도 좋습니다!
```

---