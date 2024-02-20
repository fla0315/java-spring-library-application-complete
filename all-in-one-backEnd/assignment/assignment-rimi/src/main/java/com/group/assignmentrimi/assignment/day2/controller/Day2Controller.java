package com.group.assignmentrimi.assignment.day2.controller;


import com.group.assignmentrimi.assignment.day2.dto.request.CalculationNumberRequest;
import com.group.assignmentrimi.assignment.day2.dto.request.NumbersRequest;
import com.group.assignmentrimi.assignment.day2.dto.response.CalculationNumberResponse;
import com.group.assignmentrimi.assignment.day2.dto.response.DayOfTheWeekResponse;
import com.group.assignmentrimi.assignment.day2.service.Day2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Slf4j
public class Day2Controller {

    private final Day2Service day2Service;

    public Day2Controller(Day2Service day2Service) {
        this.day2Service = day2Service;
    }

    @GetMapping("/api/v1/cal")
    public CalculationNumberResponse calculateNumber(CalculationNumberRequest request) {
        return day2Service.calculateNumber(request);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(@RequestParam LocalDate date) {
        return day2Service.getDayOfTheWeek(date);
    }

    @PostMapping("/api/v1")
    public Object calculateNumbers(@RequestBody NumbersRequest numbers) {
        return day2Service.calculateNumbers(numbers);
    }
}
