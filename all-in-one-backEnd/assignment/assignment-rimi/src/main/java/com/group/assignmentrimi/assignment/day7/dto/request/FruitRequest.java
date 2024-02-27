package com.group.assignmentrimi.assignment.day7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FruitRequest {
    private Long id;
    private String name;
    private String salesYn;
    private LocalDate warehousingDate;
    private Long price;
}
