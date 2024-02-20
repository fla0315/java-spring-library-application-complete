package com.group.assignmentrimi.assignment.day2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculationNumberResponse {
    /** 두 수의 합 */
    private Long add;
    /** 두 수의 차 */
    private Long minus;
    /** 두 수의 곱 */
    private Long multiply;
}
