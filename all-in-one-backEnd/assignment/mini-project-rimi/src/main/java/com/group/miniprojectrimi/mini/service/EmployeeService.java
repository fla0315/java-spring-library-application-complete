package com.group.miniprojectrimi.mini.service;

import com.group.miniprojectrimi.mini.code.RoleCode;
import com.group.miniprojectrimi.mini.domain.Employee;
import com.group.miniprojectrimi.mini.domain.EmployeeRepository;
import com.group.miniprojectrimi.mini.dto.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
}
