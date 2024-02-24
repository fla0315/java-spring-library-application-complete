package com.group.assignmentrimi.assignment.day5.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultDto {

    /**
     * 주사위 결과 출력
     */
    List<String> diceResult = new ArrayList<>();

}
