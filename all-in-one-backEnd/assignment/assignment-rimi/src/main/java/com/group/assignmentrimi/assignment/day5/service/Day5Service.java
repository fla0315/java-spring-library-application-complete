package com.group.assignmentrimi.assignment.day5.service;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Day5Service {

    /**
     * rollCount만큼 횟수를 돌려 나온 dieSide의 횟수를 구한다
     * @param dieSide 주사위면체 수
     * @param rollCount 돌리는 수
     */
    public void diceGame(int dieSide, int rollCount) {
        System.out.println("- 주어지는 숫자 하나를 받는다.");
        System.out.println("- 해당 숫자만큼 주사위를 던져, 각 숫자가 몇 번 나왔는지 알려준다");

        var result = IntStream.rangeClosed(1, rollCount)
                .mapToObj(i -> (int) (Math.random() * dieSide) + 1)
                .collect(Collectors.groupingBy(side -> side, Collectors.counting()));

        for (int i = 1; i <= dieSide; i++) {
            long count = result.getOrDefault(i, 0L);
            System.out.printf("%d은 %d번 나왔습니다.\n", i, count);
        }
    }
}
