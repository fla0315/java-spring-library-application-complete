package com.group.assignmentrimi.assignment.day2.service;

import com.group.assignmentrimi.assignment.day2.dto.CalculationNumberRequest;
import com.group.assignmentrimi.assignment.day2.dto.CalculationNumberResponse;
import com.group.assignmentrimi.assignment.day2.dto.DayOfTheWeekResponse;
import com.group.assignmentrimi.assignment.day2.dto.NumberDto;
import com.group.assignmentrimi.assignment.day2.dto.NumbersRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
public class Day2Service {

    /**
     * 두 수의 덧셈, 뺄셈, 곱셈을 계산한다.
     * @param request 두 수
     * @return 연산 결과
     */
    public CalculationNumberResponse calculateNumber(CalculationNumberRequest request) {

        if (request.getNumber1() == null || request.getNumber2() == null) {
            throw new NullPointerException("No value present");
        }

        var number1 = request.getNumber1();
        var number2 = request.getNumber2();

        return CalculationNumberResponse.builder()
                .add(Math.addExact(number1, number2))
                .minus(Math.subtractExact(number1, number2))
                .multiply(Math.multiplyExact(number1, number2))
                .build();
    }

    /**
     * 입력 받은 날짜로 요일을 계산한다.
     * @param date 입력 받은 날짜
     * @return 요일
     */
    public DayOfTheWeekResponse getDayOfTheWeek(LocalDate date) {

        return DayOfTheWeekResponse.builder()
                .dayOfTheWeek(date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase())
                .build();
    }

    /**
     * 입력 받은 수들의 합계를 구한다.
     * @param numbers 받은 수들
     * @return 합계
     */
    public Object calculateNumbers(NumbersRequest numbers) {

        var isEmpty = Optional.ofNullable(numbers.getNumberDto()).isPresent();
        if (isEmpty) {
            throw new NullPointerException("No value present");
        }

        return numbers.getNumberDto()
                .stream()
                .mapToLong(NumberDto::getNumber)
                .sum();
    }
}
