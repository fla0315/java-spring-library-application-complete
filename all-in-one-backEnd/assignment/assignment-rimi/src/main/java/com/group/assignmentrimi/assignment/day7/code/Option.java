package com.group.assignmentrimi.assignment.day7.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Option {

    GTE("GTE","GreaterThanEqual"),
    LTE("LTE","LessThanEqual");

    private final String code;
    private final String value;
}
