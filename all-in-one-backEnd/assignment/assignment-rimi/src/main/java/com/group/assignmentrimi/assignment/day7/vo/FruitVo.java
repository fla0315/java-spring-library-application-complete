package com.group.assignmentrimi.assignment.day7.vo;

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
public class FruitVo {

    private Long id;
    private String name;
    private String salesYn;
    private LocalDate warehousingData;
    private Long price;

}
