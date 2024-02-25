package com.group.libraryapprimi.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //find = 1개를 가져온다
    //By 뒤에 붙는 필드 이름으로 Select 쿼리의 where 문이 작성된다.

    /*
        By 앞에 들어갈 수 있는 구절 정리
        1. find : 1건을 가져온다. 반환 타입은 객체가 될 수도 있고, Optional<T>이 될 수도 있다.
        2. findAll : 쿼리 결과물이 N개인 경우 사용. List<T> 반환
        3. exists : 쿼리 결과과 존재하는지 확인. 반환타입은 boolean
        4. count : SQL의 결과 갯수를 센다. 반환타입은 long이다.
    */
    Optional<User> findByName(String name);
    boolean existsByName(String name);
    long countByAge(Integer age);

    /*
        By 뒤 각 구절은 And 나 Or로 조합할 수도 있다.
        GreaterThan : 초과
        GreaterThanEqual : 이상

        LessThan : 미만
        LessThanEqual : 이하

        Between : 사이에
        StartsWith : ~ 로 시작하는
        EndsWith : ~ 로 끝나는
     */

}
