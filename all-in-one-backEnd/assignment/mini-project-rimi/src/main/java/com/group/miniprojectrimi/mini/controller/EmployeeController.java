package com.group.miniprojectrimi.mini.controller;

import com.group.miniprojectrimi.mini.dto.request.EmployeeRequest;
import com.group.miniprojectrimi.mini.dto.response.EmployeeResponse;
import com.group.miniprojectrimi.mini.dto.response.TeamResponse;
import com.group.miniprojectrimi.mini.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee/save")
    public void saveEmployeeInfo(@RequestBody EmployeeRequest request) {
        employeeService.saveEmployeeInfo(request);
    }

    @GetMapping("/employee/inquiry")
    public List<EmployeeResponse> inquiryEmployeeInfos() {
        return employeeService.inquiryEmployeeInfos();
    }



}
