package com.group.assignmentrimi.assignment.day5.service;

import com.group.assignmentrimi.assignment.day5.dto.ResultDto;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class Day5Service {

    /**
     * rollCount만큼 횟수를 돌려 나온 dieSide의 횟수를 구한다
     *
     * @param dieSide   주사위면체 수
     * @param rollCount 돌리는 수
     */
    public ResultDto diceGame(int dieSide, int rollCount) {
        log.info("- 주어지는 숫자 하나를 받는다.");
        log.info("- 해당 숫자만큼 주사위를 던져, 각 숫자가 몇 번 나왔는지 알려준다");

        //TODO : valid check 추가 필요함.

        //주사위 돌려서 나온 횟수
        var result = IntStream.rangeClosed(1, rollCount)
                .mapToObj(i -> (int) (Math.random() * dieSide) + 1)
                .collect(Collectors.groupingBy(side -> side, Collectors.counting()));

        //response로 보낼 값 set
        var diceResult = IntStream.rangeClosed(1, dieSide)
                .mapToObj(i -> i + "은 " + result.getOrDefault(i, 0L) + "번 나왔습니다.")
                .collect(Collectors.toList());

        return ResultDto.builder().diceResult(diceResult).build();
    }
}
