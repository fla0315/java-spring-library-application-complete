package com.group.assignmentrimi.assignment.day6.dto.response;

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
public class FruitResponse {
    private Long salesAmount;
    private Long notSalesAmount;
}
