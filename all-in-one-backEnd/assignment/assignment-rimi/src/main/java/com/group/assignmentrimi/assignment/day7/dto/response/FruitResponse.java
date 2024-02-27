package com.group.assignmentrimi.assignment.day7.dto.response;

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
    private String name;
    private LocalDate warehousingDate;
    private Long price;
}
