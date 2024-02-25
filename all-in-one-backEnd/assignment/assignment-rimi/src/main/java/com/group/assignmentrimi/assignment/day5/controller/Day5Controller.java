package com.group.assignmentrimi.assignment.day5.controller;

import com.group.assignmentrimi.assignment.day5.dto.ResultDto;
import com.group.assignmentrimi.assignment.day5.service.Day5Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day5Controller {

    private final Day5Service day5Service;

    public Day5Controller(Day5Service day5Service) {
        this.day5Service = day5Service;
    }

    /**
     * 주사위의 면의 갯수와 주사위를 굴릴 횟수를 받아 나온 면들의 수를 반환한다.
     * @param dieSide 주사위의 면
     * @param rollCount 돌릴 횟수
     * @return 결과
     */
    @GetMapping("/api/v1/dice")
    public ResultDto diceGame(@RequestParam int dieSide, @RequestParam int rollCount) {
        return day5Service.diceGame(dieSide, rollCount);
    }

}
