package com.group.assignmentrimi.assignment.day4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FruitResponse {
    private Long salesAmount;
    private Long notSalesAmount;
}
