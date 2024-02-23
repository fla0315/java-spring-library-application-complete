package com.group.assignmentrimi.assignment.day5.controller;

import com.group.assignmentrimi.assignment.day4.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day5.service.Day5Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day5Controller {

    private final Day5Service day5Service;

    public Day5Controller(Day5Service day5Service) {
        this.day5Service = day5Service;
    }

    @GetMapping("/api/v1/dice")
    public void diceGame(@RequestParam int dieSide, @RequestParam int rollCount) {
        day5Service.diceGame(dieSide, rollCount);
    }



}
