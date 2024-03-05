package com.group.miniprojectrimi.mini.controller;

import com.group.miniprojectrimi.mini.dto.request.EmployeeRequest;
import com.group.miniprojectrimi.mini.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //직원 등록
    @PostMapping("/employee/save")
    public void saveEmployeeInfo(@RequestBody EmployeeRequest request) {
        employeeService.saveEmployeeInfo(request);
    }


}
