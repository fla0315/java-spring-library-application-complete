package com.group.miniprojectrimi.mini.controller;

import com.group.miniprojectrimi.mini.service.CommuteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommuteController {

    private final CommuteService commuteService;

    //출근 컨트롤러
    @GetMapping("/employee/commute/{id}")
    public void commuteEmployee(@PathVariable Long id) {
        commuteService.commuteEmployee(id);
    }



    //출근 기능 -> 등록된 직원은 출근을 할 수 있어야 한다. 출근의 경우 이름은 동명이인이 있을 수 있으므로, DB에 등록된 id를 기준으로 처리된다.
    //퇴근 기능 -> 출근한 직원은 퇴근을 할 수 있어야 한다. 퇴근 역시 DB에 등록된 id를 기준으로 처리된다.

    //특정 직원의 날짜별 근무시간을 조회하는 기능
    //특정 직원 id와 2024-01 과 같이 연/월을 받으면, 날짜별 근무 시간과 총 합을 반환해야 한다. 이때 근무 시간은 분단위로 계산된다.
    //예를 들어 1번id를 갖는 직원에 대해 2024-01 을 기준으로 조회하면, 다음과 같이 응답이 반환되어야 한다.


}
