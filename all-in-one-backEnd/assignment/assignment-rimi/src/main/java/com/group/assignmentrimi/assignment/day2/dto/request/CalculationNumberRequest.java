package com.group.assignmentrimi.assignment.day2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculationNumberRequest {
    /** 첫번째 수 */
    private Long number1;
    /** 두번째 수 */
    private Long number2;
}
