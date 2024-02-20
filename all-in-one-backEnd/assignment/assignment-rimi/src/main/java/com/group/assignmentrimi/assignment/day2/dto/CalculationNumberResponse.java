package com.group.assignmentrimi.assignment.day2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculationNumberResponse {
    private Long add;
    private Long minus;
    private Long multiply;
}