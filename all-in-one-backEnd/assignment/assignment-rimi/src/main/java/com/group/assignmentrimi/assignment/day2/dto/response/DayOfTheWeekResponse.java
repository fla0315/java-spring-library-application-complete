package com.group.assignmentrimi.assignment.day2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DayOfTheWeekResponse {
    /** 요일 */
    private String dayOfTheWeek;
}
