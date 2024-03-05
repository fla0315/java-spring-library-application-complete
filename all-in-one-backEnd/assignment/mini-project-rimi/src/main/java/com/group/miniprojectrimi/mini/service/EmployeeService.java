package com.group.miniprojectrimi.mini.service;

import com.group.miniprojectrimi.mini.code.RoleCode;
import com.group.miniprojectrimi.mini.domain.employee.Employee;
import com.group.miniprojectrimi.mini.domain.employee.EmployeeRepository;
import com.group.miniprojectrimi.mini.dto.request.EmployeeRequest;
import com.group.miniprojectrimi.mini.dto.response.EmployeeResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public void saveEmployeeInfo(EmployeeRequest request) {
        employeeRepository.save(Employee.builder()
                                        .name(request.getName())
                                        .role(RoleCode.valueOf(request.getRole()).getCode())
                                        .teamName(request.getTeamName())
                                        .birthday(request.getBirthday())
                                        .wordStartDate(ObjectUtils.defaultIfNull(request.getWordStartDate(), LocalDate.now()))
                                        .build());
    }


    @Transactional
    public List<EmployeeResponse> inquiryEmployeeInfos() {
        return employeeRepository.findAll().stream().map(vo -> EmployeeResponse.builder()
                                                                               .name(vo.getName())
                                                                               .role(RoleCode.valueOf(vo.getRole()).getName())
                                                                               .teamName(vo.getTeamName())
                                                                               .birthday(vo.getBirthday())
                                                                               .wordStartDate(vo.getWordStartDate())
                                                                               .build()).toList();
    }
}
