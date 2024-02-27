package com.group.assignmentrimi.assignment.day6.controller;


import com.group.assignmentrimi.assignment.day6.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day6.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day6.service.Day6Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Day6Controller {

    private final Day6Service day6Service;

    public Day6Controller(Day6Service day6Service) {
        this.day6Service = day6Service;
    }

    @PostMapping("/api/v1/day6/fruit")
    public void saveFruitInfo(@RequestBody FruitRequest fruitInfo) {
        day6Service.saveFruitInfo(fruitInfo);
    }

    @PutMapping("/api/v1/day6/fruit")
    public void salesFruitById(@RequestBody FruitRequest fruitInfo) {
        day6Service.salesFruitById(fruitInfo);
    }

    @GetMapping("/api/v1/day6/fruit/stat")
    public FruitResponse findFruitAmountByFruitName(@RequestParam String fruitName) {
        return day6Service.findFruitAmountByFruitName(fruitName);
    }

}
