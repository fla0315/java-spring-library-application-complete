package com.group.assignmentrimi.assignment.day7.controller;


import com.group.assignmentrimi.assignment.day7.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day7.service.Day7Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Day7Controller {

    private final Day7Service day7Service;

    public Day7Controller(Day7Service day7Service) {
        this.day7Service = day7Service;
    }

    @PostMapping("/api/v1/fruit/save")
    public void saveFruitInfo(@RequestBody FruitRequest fruitInfo) {
        day7Service.saveFruitInfo(fruitInfo);
    }

    @PutMapping("/api/v1/fruit/update")
    public void salesFruitById(@RequestBody FruitRequest fruitInfo) {
        day7Service.updateFruitInfo(fruitInfo);
    }

}
