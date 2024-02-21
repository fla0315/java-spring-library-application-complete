package com.group.assignmentrimi.assignment.day4.controller;


import com.group.assignmentrimi.assignment.day4.dto.request.FruitRequest;
import com.group.assignmentrimi.assignment.day4.dto.response.FruitResponse;
import com.group.assignmentrimi.assignment.day4.service.Day4Service;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Day4Controller {

    private final Day4Service day4Service;

    public Day4Controller(Day4Service day4Service) {
        this.day4Service = day4Service;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruitInfo(@RequestBody FruitRequest fruitInfo) {
        day4Service.saveFruitInfo(fruitInfo);
    }

    @PutMapping("/api/v1/fruit")
    public void salesFruitById(@RequestBody FruitRequest fruitInfo) {
        day4Service.salesFruitById(fruitInfo);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse findFruitAmountByFruitName(@RequestParam String fruitName) {
        return day4Service.findFruitAmountByFruitName(fruitName);
    }

}
