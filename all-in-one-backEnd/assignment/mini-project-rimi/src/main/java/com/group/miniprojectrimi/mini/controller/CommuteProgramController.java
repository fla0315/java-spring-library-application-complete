package com.group.miniprojectrimi.mini.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommuteProgramController {

    //1. 팀 테이블
    //2. 직원 테이블


    //1. 팀 등록 기능 -> 회사에 있는 팀을 등록할 수 있어야합니다. 팀이 가져야하는 정보는 다음과 같습니다. (팀 이름)
    //2. 직원 등록 기능
        //2-1 직원을 등록할 수 있어야 합니다. (직원이름, 팀의 매니저인지 매니저가 아닌지 여부, 회사에 들어온 일자, 생일)

    //3. 팀 조회 기능 - 모든 팀의 정보를 한 번에 조회할 수 있어야 합니다.
    /**
     * [
     *     {
     *         "name": "팀 이름",
     *         "manager": "팀 매니저 이름", //없을 경우 null
     *         "memberCount": 팀 인원 수 [숫자]
     *     }, ...
     * ]
     */

    //4. 직원 조회 기능 - 모든 직원의 정보를 한 번에 조회할 수 있어야 합니다.

    /**
     * [
     *     {
     *         "name": "직원 이름",
     *         "teamName": "소속 팀 이름",
     *         "role": "MANAGER" or "MEMBER", // 팀의 매니저인지 아닌지
     *         "birthday": "1989-01-01",
     *         "workStartDate": "2024-01-01"
     *     }, ...
     * ]
     */


}
