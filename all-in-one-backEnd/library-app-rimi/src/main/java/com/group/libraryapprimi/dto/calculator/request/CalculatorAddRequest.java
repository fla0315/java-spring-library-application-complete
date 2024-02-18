package com.group.libraryapprimi.dto.calculator.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CalculatorAddRequest {

    private int number1;
    private int number2;

}
