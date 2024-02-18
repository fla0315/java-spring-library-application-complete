package com.group.libraryapprimi.controller.calculator;

import com.group.libraryapprimi.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapprimi.dto.calculator.request.CalculatorMultiplyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {


    /**
     * 두 수의 덧셈
     * @param request number1, number2
     * @return 두 수의 합
     */
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return Math.addExact(request.getNumber1(), request.getNumber2());
    }

    /**
     * 두 수의 곱셈
     * @param request number1, number2
     * @return 두 수의 곱
     */
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return Math.multiplyExact(request.getNumber1(), request.getNumber2());
    }


}
