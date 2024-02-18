package com.group.libraryapprimi.controller.calculator;

import com.group.libraryapprimi.dto.calculator.request.CalculatorAddRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {


    /**
     * 두개의 숫자를 더한다
     * @param request 두개의 숫자
     * @return 합계
     */
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        log.debug("request = {}",request);
        return request.getNumber1() + request.getNumber2();
    }


}
