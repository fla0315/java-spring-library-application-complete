
package com.group.miniprojectrimi.mini.service;

import com.group.miniprojectrimi.mini.domain.commute.Commute;
import com.group.miniprojectrimi.mini.domain.commute.CommuteRepository;
import com.group.miniprojectrimi.mini.domain.employee.Employee;
import com.group.miniprojectrimi.mini.domain.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommuteService {

    private final CommuteRepository commuteRepository;
    private final EmployeeRepository employeeRepository;

    //직원 출근
    @Transactional
    public void commuteEmployee(Long id) {
        Employee employeeInfo
                = employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        var commute = commuteRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        log.debug("날짜 비교 = {}" ,commute.getCommuteDate().compareTo(LocalDate.now()));
        AtomicLong commuteSeq = new AtomicLong();

        commuteRepository.save(Commute.builder()
                                      .employeeId(employeeInfo.getId())
                                      .commuteSeq(commuteSeq.incrementAndGet())
                                      .commuteYn(true)
                                      .commuteDate(LocalDate.now())
                                      .build());


    }

}
