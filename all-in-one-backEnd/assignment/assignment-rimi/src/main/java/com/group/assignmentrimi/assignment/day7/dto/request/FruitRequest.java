package com.group.assignmentrimi.assignment.day7.dto.request;

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
public class FruitRequest {
    private Long id;
    private String name;
    private LocalDate warehousingDate;
    private Long price;
}
